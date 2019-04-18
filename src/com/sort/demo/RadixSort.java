package com.sort.demo;

/**
 * @Description:    基数RadixSort排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:48
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:48
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class RadixSort {

    /**
     * 获取待排序数组中的最大值
     * @param array
     * @return
     */
    private static int getMax(int[] array){

        int max = array[0];
        for(int i = 1;i<array.length;i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 基数排序实现
     * @param arr
     * @param exp
     */
   private static void countSort(int arr[], int exp) {
       /**
        * 对数组按照"某个位数"进行排序(桶排序)
        *
        * 参数说明：
        *     a -- 数组
        *     exp -- 位数。对数组a按照该指数进行排序。
        *
        * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
        *    (01) 当exp=1表示按照"个位"对数组a进行排序
        *    (02) 当exp=10表示按照"十位"对数组a进行排序
        *    (03) 当exp=100表示按照"百位"对数组a进行排序
        *    ...
        */
        int n = arr.length;
        //结果数组（排好序）
        int output[] = new int[n];
        int i;
        int[] count = new int[10];
        count[0] = 0;
        //存放数据出现的次数
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        //更改count[i]。目的是让更改后的count[i]的值，是该数据在output[]相应的位置。
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        //将数据放到结果数组中
        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        //将排好序的数据放回到原来的数组上
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * 基数排序 --- 时间复杂度O(N)
     * @param arr
     */
    public static void radixsort(int arr[]) {
        int n = arr.length;
        int m = getMax(arr);
        for (int exp = 1; m/exp > 0; exp *= 10) {
            countSort(arr,exp);
        }
    }

    public static void main(String[] args){
        int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,22,22,22,23,21,20,23,24,21,23,23};
        radixsort(a);
        for(int i = 0;i<a.length;i++) {
            System.out.print(a[i]+"\t");
        }
    }
}
