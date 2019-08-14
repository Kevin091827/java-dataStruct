package com.string_match.demo;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:Bf
 * @Description: TODO
 */
public class Bf {

    /**
     * 字符串匹配
     * 【暴力解】
     * 【O(mn)】
     * @param txt
     * @param pat
     * @return
     */
    public static int forceSearch(String txt,String pat){
        int txtLen = txt.length();
        int patLen = pat.length();
        int i = 0;
        int j = 0;
        while(i < txtLen && j < patLen){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }else {
                j = 0;
                i = i-j+1;
            }
        }
        if(j == patLen){
            return i - j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String txt = "ABCADA";
        String pat = "ADA";
        System.out.println("----->"+forceSearch(txt,pat));
    }

}
