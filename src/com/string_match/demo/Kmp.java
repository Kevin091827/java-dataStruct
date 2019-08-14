package com.string_match.demo;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:Kmp
 * @Description: TODO
 */
public class Kmp {

    /**
     * KMP
     * O(m+n) m:字符串长度，n：next数组长度
     * @param txt
     * @param pat
     * @param next
     * @return
     */
    public static int kmpSearch(String txt,String pat,int[] next){
        int txtLen = txt.length();
        int patLen = pat.length();
        int i = 0;
        int j = 0;
        while(i < txtLen && j < patLen){
            if(j == -1 || txt.charAt(i) == pat.charAt(j)){
                //匹配则继续比较下一个元素
                j++;
                i++;
            }else{
                //不匹配则将模式串移动到以对应next数组元素为索引的位置
                j = next[j];
            }
        }
        if(j == patLen){
            return i - j;
        }else {
            return -1;
        }
    }

    /**
     * 寻找前缀后缀最长公共元素长度
     * 获取next数组，告知下一次应该跳到模式串的哪一个位置
     * @param patStr
     * @param next
     */
    public static void next(String patStr,int[] next){
        int length = patStr.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < length - 1){
            if(k == -1 || patStr.charAt(k) == patStr.charAt(j)){
                ++k;
                ++j;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        for(int i = 0;i<next.length;i++) {
            System.out.println("---->" +next[i]);
        }
    }

    public static void main(String[] args) {
        String txt = "ABCADAADBDADCADC";
        String pat = "ADCADC";
        int[] next = new int[pat.length()];
        next(pat,next);
        System.out.println("----->"+kmpSearch(txt,pat,next));
    }
}
