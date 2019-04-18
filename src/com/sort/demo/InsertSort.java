package com.sort.demo;import javax.swing.text.GapContent;

/**
 * @Description:    插入排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:31
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:31
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class InsertSort {

	/**
	 * 插入排序 O(N^2)
	 * @param a
	 */
	public static void insertSort(int[] a) {
		
		int j;
		//外层循环控制需要排序的趟数 -- a.length - 1
		for(int p = 1;p<a.length;p++) {
			//当前数据
			int tmp = a[p];
			//比较---当前数据小于前一位数据，则交换位置
			for(j = p;j>0 && tmp<a[j-1];j--) {
				a[j] = a[j-1];
			}
			//退出循环--找到合适位置，将当前数据放入该位置
			a[j] = tmp;
		}
		
	}
	
	
	/**
	 * 优化	--	插入排序
	 * 希尔排序	--	希尔增量 O(N^2)
	 * 			--	Hibbard增量O(N^3/2)
	 * @param a
	 */
	public static void shellSort(int[] a) {
		
		int j;
		//最外层循环控制步长 -- 减少插入排序的数据量
		for(int gap = a.length/2;gap>0;gap/=2 ) {
			//内层嵌套for循环是插入排序
			for(int p = gap;p<a.length;p++) {
				int tmp = a[p];
				for(j = p;j>=gap && tmp<a[j-gap];j-=gap) {
					a[j] = a[j-gap];
				}
				a[j] = tmp;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,2,8,9,2,4,5,10,20,12};
		insertSort(a);
		int[] b = {1,3,4,2,1,9,8,10,5,4,3,2,1,20};
		shellSort(b);
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println("\n");
		for(int i = 0;i<b.length;i++) {
			System.out.print(b[i]+"\t");
		}
	}

}
