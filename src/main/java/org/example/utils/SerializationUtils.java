package org.example.utils;

import java.io.*;

public class SerializationUtils {
    public static byte[] serialize(Object obj) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to serialize object", e);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Failed to deserialize object", e);
        }
    }
    // 将对象序列化为字节数组
    private static byte[] serializeObjectToBytes(Object obj) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        }
    }
    // 将字节数组转换为十六进制字符串
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    // 将对象序列化并转换为十六进制字符串
    public static String serializeObjectToHex(Object obj) throws IOException {
        byte[] bytes = serializeObjectToBytes(obj);
        return bytesToHex(bytes);
    }
}
