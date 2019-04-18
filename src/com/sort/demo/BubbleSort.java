package com.sort.demo;

/**
 * @Description:    冒泡排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:41
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:41
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BubbleSort {

    /**
     * 冒泡排序 --- O（N^2）
     * 有序数组 --- O（N）
     * @param a
     */
    public static void bubleSort(int[] a){
        int tmp;
        //第一层循环是比较的轮数
        for(int i = 0;i<a.length;i++){
            //第二层循环是每一轮比较的次数
            for(int j = i;j<a.length-i-1;j++){
                //交换
                if(a[j] > a[j+1]){
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,22,22,22,23,21,20,23,24,21,23,23};
        bubleSort(a);
        for(int i = 0;i<a.length;i++) {
            System.out.print(a[i]+"\t");
        }
    }

}
