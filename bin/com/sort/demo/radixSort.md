#### 基数排序
###### 算法思路
基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。他是根据键值的每位数字来分配桶；然后每一位每一位的比较

1. 最低位优先法，简称LSD法：先从最低位开始排序，再对次低位排序，直到对最高位排序后得到一个有序序列；
2. 最高位优先法，简称MSD法：先从最高位开始排序，再逐个对各分组按次高位进行子排序，循环直到最低位。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418151345834.gif)
###### 算法分析
1. 基数排序是稳定排序,在某些时候，基数排序法的效率高于其它的稳定性排序法。
2. 时间复杂度：O(N）
3. 空间复杂度：O(N）
###### 算法实现
```java
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

```