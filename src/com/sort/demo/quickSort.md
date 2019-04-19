### 快速排序
**算法思路：**
随便选取一项（一般是中间值），然后形成三个组，小于被选项组，大于被选项组合等于被选项组，递归的对小于被选项组，大于被选项组进行排序，然后合并这三个组。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190416152446970.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTkyMjI4OQ==,size_16,color_FFFFFF,t_70)
**核心思想：**------- 分治思想

**算法分析：**
1. 快速排序是一个原地排序算法，是一个不稳定的排序算法，因为其在数据交换过程中可能会改变相等元素的原始位置。
2. 平均时间复杂度O(NlogN) ,最坏时间复杂度O(N^2) 
3. 如果快速排序每次都将数据分成相等的两部分，则快排的时间复杂度和归并排序相同，也是O(nlogn)，但这种情况是很难实现的。如果数据原来已经是有序的，则每次的分区都是不均等的，我们需要进行 n 次分区才能完成整个排序，此时快排的时间复杂度就退化成了O(n^2)

```java
public class QuickSort {

	/**
	 * 快速排序   O(NlogN)
	 * @param list
	 */
	private static void quickSort(ArrayList<Integer> list) {
		
		if(list.size()>1) {
			
			ArrayList<Integer> smallerlist = new ArrayList<>();
			ArrayList<Integer> centerList = new ArrayList<>();
			ArrayList<Integer> largeList = new ArrayList<>();
			
			//中间元素
			Integer center = list.get(list.size()/2);
			
			//分类
			for(Integer i : list) {
				if(i < center) {
					//比中间元素小
					smallerlist.add(i);
				}else if (i > center) {
					//比中间元素大
					largeList.add(i);
				}else {
					//与中间元素相等
					centerList.add(i);
				}
			}
			
			//分组排序
			quickSort(smallerlist);
			quickSort(largeList);
			
			//清空
			list.clear();
			//合并
			list.addAll(smallerlist);
			list.addAll(centerList);
			list.addAll(largeList);
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31};
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<a.length;i++) {
			list.add(a[i]);
		}
		
		quickSort(list);
		
		for(Integer integer : list) {
			System.out.println(integer+"\t");
		}
	}
}
```
结果：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190416151653826.png)

