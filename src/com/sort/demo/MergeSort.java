package com.sort.demo;

/**
 * @Description:    归并排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:31
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:31
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class MergeSort {

	/**
	 * 归并排序   O(NlogN)
	 * 
	 * 思想：分治
	 * @param oldArray
	 * @param tmpArray
	 * @param left
	 * @param right
	 */
	private static void mergeSort(int[] oldArray,int[] tmpArray,int left,int right) {
		if(left < right) {
			//中间元素下标
			int center = (left + right)/2;
			//分治左边数组[left , center]
			mergeSort(oldArray, tmpArray, left,center);
			//分治右边数组[center+1 , right]
			mergeSort(oldArray, tmpArray, center+1, right);
			//分开排序后合并成一个新数组在copy会原数组，此时原数组已经有序
			merge(oldArray, tmpArray, left, center+1,right);
			
		}
	}
	
	/**
	 * 排序，合并
	 * @param oldArray
	 * @param tmpArray
	 * @param leftStart
	 * @param rightStart
	 * @param rightEnd
	 */
	private static void merge(int[] oldArray, int[] tmpArray, int leftStart, int rightStart, int rightEnd) {
		
		//左数组开始下标
		int leftEnd = rightStart - 1;
		//辅助数组起始下标
		int tmpPos = leftStart;
		//数组元素数量
		int numElements = rightEnd - tmpPos + 1;
		
		//左右数组进行比较,按序放入辅助数组
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if(oldArray[leftStart] <= oldArray[rightStart]) {
				tmpArray[tmpPos++] = oldArray[leftStart++];
			}else {
				tmpArray[tmpPos++] = oldArray[rightStart++];
			}
		}
		
		//判断子数组是否还有元素，有则拷贝到 tmp 后面
		while(leftStart <= leftEnd) {
			tmpArray[tmpPos++] = oldArray[leftStart++];
		}
		
		//判断子数组是否还有元素，有则拷贝到 tmp 后面
		while(rightStart <= rightEnd) {
			tmpArray[tmpPos++] = oldArray[rightStart++];
		}
		
		//复制辅助数组回原数组
		for(int i = 0;i<numElements;i++,rightEnd--) {
			oldArray[rightEnd] = tmpArray[rightEnd];
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31};
		int[] tmpArray = new int[a.length];
		mergeSort(a, tmpArray, 0, a.length-1);
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		
	}

}
