package com.rookie.stack.discord.common.test;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.StandardCharsets;

/**
 * @author eumenides
 * @description
 * @date 2024/5/31
 */
public class EncryptHandlerTest {

    private static final byte[] KEYS = "jaguar831143abcd".getBytes(StandardCharsets.UTF_8);
    private static final AES AES_INSTANCE = SecureUtil.aes(KEYS);

    public static void main(String[] args) {
        String originalText = "testPassword123";

        // 加密
        String encryptedText = AES_INSTANCE.encryptBase64(originalText);
        System.out.println("Encrypted: " + encryptedText);

        // 解密
        String decryptedText = AES_INSTANCE.decryptStr(encryptedText);
        System.out.println("Decrypted: " + decryptedText);

        // 验证
        if (originalText.equals(decryptedText)) {
            System.out.println("Encryption and decryption are consistent.");
        } else {
            System.out.println("There is an inconsistency in the encryption and decryption process.");
        }
    }
}
