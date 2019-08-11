package com.crypto.demo;

import javax.crypto.*;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/**
 * @Description:    java加密模块---AES加密
 * @Author:         Kevin
 * @CreateDate:     2019/5/2 2:08
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/5/2 2:08
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class AesDemo {

    /**
     * AES加密
     * @param data
     * @return
     */
    public static byte[] encrypt(String data,String key){
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,getSecretKey(key));
            result = cipher.doFinal(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * AES解密
     * @param data
     * @return
     */
    public static String decrypt(byte[] data,String key){
        String result = null;
        try {
            //获取cipher
            Cipher cipher = Cipher.getInstance("AES");
            //初始化cipher，并且指定模式
            cipher.init( Cipher.DECRYPT_MODE,getSecretKey(key));
            //加密
            result = new String(cipher.doFinal(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获得加密和解密所需的密钥
     * @return
     */
    private static SecretKey getSecretKey(String key){
        if (null == key || key.length() == 0) {
            throw new NullPointerException("key not is null");
        }
        SecretKey secretKey = null;
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            keyGenerator.init(128,secureRandom);
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    public static void main(String[] args) {
        String pwd = "123456789";
        byte[] pwd1 = encrypt(pwd,"test");
        System.out.println("----->"+pwd1);
        System.out.println("----->"+decrypt(pwd1,"test"));
    }
}
