#### 一，冒泡排序
###### 算法思路
冒泡排序的原理可以顾名思义：把每个数据看成一个气泡，按初始顺序自底向上依次对两两气泡进行比较，对上重下轻的气泡交换顺序（这里用气泡轻、重表示数据大、小），保证轻的气泡总能浮在重的气泡上面，直到最轻的气泡浮到最上面；保持最后浮出的气泡不变，对余下气泡循环上述步骤，直到所有气泡从轻到重排列完毕。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190418152527295.gif)
###### 算法分析
1. 稳定排序
2. 时间复杂度；乱序：O(N^2)，有序：O(N)
3. 空间复杂度：O(1)
###### 算法实现
```java
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
```