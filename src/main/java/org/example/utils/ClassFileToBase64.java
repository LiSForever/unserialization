package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ClassFileToBase64 {
    public static void main(String[] args) {
        String classFilePath = "C:\\Users\\tlj\\Desktop\\tmp\\java8u66\\CalcExample.class";

        try {
            // 读取 class 文件的字节数组
            byte[] classBytes = Files.readAllBytes(Paths.get(classFilePath));

            // 将字节数组转换为 Base64 编码字符串
            String base64String = Base64.getEncoder().encodeToString(classBytes);

            // 输出 Base64 编码字符串
            System.out.println(base64String);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}