package org.example.load;

import java.lang.reflect.Method;
import java.util.Base64;

public class HelloDefineClass {
    public static void main(String[] args) throws Exception {
        Method defineClass =
                ClassLoader.class.getDeclaredMethod("defineClass", String.class,
                        byte[].class, int.class, int.class);
        defineClass.setAccessible(true);
        byte[] code =
                Base64.getDecoder().decode("yv66vgAAADQAMQoADAAWCQAXABgIABkKABoAGwoAHAAdCAAeCgAcAB8HACAHACEKAAkAIgcAIwcAJAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEADVN0YWNrTWFwVGFibGUHACABAApTb3VyY2VGaWxlAQAQQ2FsY0V4YW1wbGUuamF2YQwADQAOBwAlDAAmACcBAAxDYWxjIEV4YW1wbGUHACgMACkAKgcAKwwALAAtAQAIY2FsYy5leGUMAC4ALwEAE2phdmEvaW8vSU9FeGNlcHRpb24BABpqYXZhL2xhbmcvUnVudGltZUV4Y2VwdGlvbgwADQAwAQALQ2FsY0V4YW1wbGUBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAGChMamF2YS9sYW5nL1Rocm93YWJsZTspVgAhAAsADAAAAAAAAgABAA0ADgABAA8AAAAtAAIAAQAAAA0qtwABsgACEgO2AASxAAAAAQAQAAAADgADAAAACwAEAAwADAANAAgAEQAOAAEADwAAAFQAAwABAAAAF7gABRIGtgAHS6cADUu7AAlZKrcACr+xAAEAAAAJAAwACAACABAAAAAWAAUAAAAGAAkACQAMAAcADQAIABYACgASAAAABwACTAcAEwkAAQAUAAAAAgAV");
        System.out.println("start defineClass ------");
        Class hello = (Class) defineClass.invoke(ClassLoader.getSystemClassLoader(), "CalcExample", code,
                0, code.length);
        System.out.println("end defineClass ------");
        hello.newInstance();
    }

}
