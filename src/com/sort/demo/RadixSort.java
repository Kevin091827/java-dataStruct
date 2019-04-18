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
        int n = arr.length;
        int output[] = new int[n];
        int i;
        int[] count = new int[10];
        count[0] = 0;
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

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
