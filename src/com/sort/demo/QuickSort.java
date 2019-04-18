package com.sort.demo;

import java.util.ArrayList;
import java.util.Arrays;

import com.list.demo.List;

/**
 * @Description:    快速排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:32
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:32
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
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
			System.out.print(integer+"\t");
		}
	}
}
