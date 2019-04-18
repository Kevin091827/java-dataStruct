package com.sort.demo;

/**
 * @Description:    选择排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:32
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:32
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class SelectSort {

	/**
	 * 获取左孩子的下标
	 * 
	 * 父亲：(i-1)/2
	 * 左孩子：2*i+1
	 * 右孩子：2*i+2
	 * 
	 * @param i
	 * @return
	 */
	private static int leftChild(int i) {
		return (2 * i) + 1;
	}
	

	/**
	 * 交换
	 * @param a
	 * @param fromIndex
	 * @param toIndex
	 */
	private static void swapReference(int[] a,int fromIndex,int toIndex) {
		
		int tmp = a[fromIndex];
		a[fromIndex] = a[toIndex];
		a[toIndex] = tmp;
	}
	
	/**
	 * 重建堆（下滤）
	 * @param a
	 * @param i
	 * @param n
	 */
	private static void percDown(int[] a,int i,int n) {
		
		int child;
		//保存父节点值
		int tmp;
		//父节点和左右孩子比较，找出三者最大值做父节点建最大堆
		for(tmp = a[i];leftChild(i)<n;i = child) {
			child = leftChild(i);
			//左孩子<右孩子 ，child指向右孩子
			if(child != n-1 && a[child]<a[child+1]) {
				child++;
			}
			//孩子比父节点大，则交换
			if (tmp<a[child]) {
				a[i] = a[child];
			}
			//父节点最大则跳出循环
			else {
				break;
			}
		}
		//完成交换
		a[i] = tmp;
	}
	
	/**
	 * 堆排序
	 * 
	 * 1.建堆
	 * 2.删除最大节点（交换到数组（堆）末端）
	 * 3.重建堆
	 * 
	 * @param a
	 */
	public static void heapSort(int[] a) {
		
		for(int i = a.length/2-1;i>=0;i--) {
			percDown(a, i, a.length);
		}
		for(int i = a.length-1;i>0;i--) {
			swapReference(a,0,i);
			percDown(a, 0, i);
		}		
	}
	
	public static void main(String[] args) {
		int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31};
		System.out.println(a.length);
		heapSort(a);
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
	}
	
}
