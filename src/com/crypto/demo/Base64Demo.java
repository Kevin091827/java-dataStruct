package com.crypto.demo;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.lang.reflect.Method;

/**
 * @Description:    java加密模块---Base64实现加密解密(直接依赖于jdk，是可逆加密操作)
 * @Author:         Kevin
 * @CreateDate:     2019/5/2 1:44
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/5/2 1:44
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class Base64Demo {

    /**
     * Base64加密
     * @param data
     * @return
     */
    public static String base64Encode(byte[] data){
        String result = null;
        try {
            Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
            Method method = clazz.getMethod("encode",byte[].class);
            //Base64的加密方法是静态方法
            result = (String) method.invoke(null,data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Base64解密
     * @param data
     * @return
     */
    public static byte[] base64Decode(String data){
        byte[] result = null;
        try {
            Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
            Method method = clazz.getMethod("decode",byte[].class);
            //Base64的加密方法是静态方法
            result = (byte[]) method.invoke(null,data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
