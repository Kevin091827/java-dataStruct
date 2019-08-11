package com.crypto.demo;

import javax.crypto.Cipher;
import java.security.*;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:RSA
 * @Description: TODO
 */
public class RSA {

    /**
     * 公钥加密
     * @param data
     * @param publicKey
     * @return
     */
    public static byte[] publicEncrytype(String data,PublicKey publicKey){
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            result = cipher.doFinal(data.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 私钥解密
     * @param data
     * @param privateKey
     * @return
     */
    public static String privateDecrytypr(byte[] data,PrivateKey privateKey){
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            result = new String(cipher.doFinal(data),"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获得公钥
     * @param keyPair
     * @return
     */
    private static PublicKey getPublicKey(KeyPair keyPair){
        return keyPair.getPublic();
    }

    /**
     * 获得私钥
     * @param keyPair
     * @return
     */
    private static PrivateKey getPrivateKey(KeyPair keyPair){
        return keyPair.getPrivate();
    }

    /**
     * 获得密钥对
     * @return
     */
    private static KeyPair getKeyPair(){
        KeyPair keyPair = null;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            SecureRandom secureRandom = new SecureRandom();
            keyPairGenerator.initialize(512,secureRandom);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyPair;
    }

    public static void main(String[] args) {
        KeyPair keyPair = getKeyPair();
        System.out.println("---->"+publicEncrytype("123456789",getPublicKey(keyPair)).toString());
        System.out.println("---->"+privateDecrytypr(publicEncrytype("123456789",getPublicKey(keyPair)),getPrivateKey(keyPair)));
    }
}
