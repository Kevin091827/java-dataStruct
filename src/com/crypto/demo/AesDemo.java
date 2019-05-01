package com.crypto.demo;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
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

    //指定字符编码
    static Charset charset = Charset.forName("UTF-8");

    /**
     * 获取SecretKey(加密和解密都需要)
     * @return
     */
    private static SecretKey getSecretKey(){
        SecretKey secretKey = null;
        try {
            //获取key生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //获取随机数
            SecureRandom secureRandom = new SecureRandom();
            //key初始化
            keyGenerator.init(secureRandom);
            //获取key
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretKey;
    }

    /**
     * AES加密
     * @param data
     * @return
     */
    public static byte[] encrypt(String data){
        byte[] result = null;
        try {
            //获取cipher
            Cipher cipher = Cipher.getInstance("AES");
            //初始化cipher，并且指定模式
            cipher.init( Cipher.ENCRYPT_MODE,getSecretKey());
            //加密
            result = cipher.doFinal(data.getBytes(charset));
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
    public static String decrypt(byte[] data){
        String result = null;
        try {
            //获取cipher
            Cipher cipher = Cipher.getInstance("AES");
            //初始化cipher，并且指定模式
            cipher.init( Cipher.DECRYPT_MODE,getSecretKey());
            //加密
            result = new String(cipher.doFinal(data),charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
