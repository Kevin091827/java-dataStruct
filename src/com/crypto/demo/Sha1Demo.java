package com.crypto.demo;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:    java加密模块---sha1加密
 * @Author:         Kevin
 * @CreateDate:     2019/5/2 1:57
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/5/2 1:57
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class Sha1Demo {

    /**
     * 方式一：依赖于第三方commons-codec-1.9 jar包实现sha1加密
     * @param data
     * @return
     */
    public static String getSha1(byte[] data){
        return DigestUtils.sha1Hex(data);
    }

    /**
     * 方式二：sha1加密
     * @param src
     * @return
     */
    public static String getSha1(String src) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(src.getBytes());
            char[] chars= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for(byte b:digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[b&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
