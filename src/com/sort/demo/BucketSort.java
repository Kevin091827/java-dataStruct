package com.sort.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:    桶排序
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:31
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:31
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BucketSort {

	
		/**
		 * 桶排序1
		 * @param data
		 * @param min	min的值为0
		 * @param max	max的值为待排序数组中最大值+1
		 */
	  	public static void bucketSort(int[] data, int min, int max) {  
	  		
			// 缓存数组  
		    int[] tmp = new int[data.length];  
		    // buckets用于记录待排序元素的信息  
		    // buckets数组定义了max-min个桶  
		    int[] buckets = new int[max - min];  
		    // 计算每个元素在序列出现的次数  
		    for (int i = 0; i < data.length; i++) {  
		        buckets[data[i] - min]++;  
		    }  
		    // 计算“落入”各桶内的元素在有序序列中的位置  
		    for (int i = 1; i < max - min; i++) {  
		        buckets[i] = buckets[i] + buckets[i - 1];  
		    }  
		    // 将data中的元素完全复制到tmp数组中  
		    System.arraycopy(data, 0, tmp, 0, data.length);  
		    // 根据buckets数组中的信息将待排序列的各元素放入相应位置  
		    for (int k = data.length - 1; k >= 0; k--) {  
		         data[--buckets[tmp[k] - min]] = tmp[k];  
		    }  
		    
		}
	 

		/**
		 * 桶排序2
		 * @param data
		 * @param max
		 * @return
		 */
		public static void bucketSort(int[] data,int max) {
	
			//int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31};
			// 缓存数组  
		    int[] tmp = new int[data.length];  
		    // buckets用于记录待排序元素的信息  
		    // buckets数组定义了max+1个桶  
		    int[] buckets = new int[max+1];  
		    // 计算每个元素在序列出现的次数  
		    for (int i = 0; i < data.length; i++) {  
		        buckets[data[i]]++;  
		    }  
		    
		    // 计算“落入”各桶内的元素在有序序列中的位置  
		    for (int i = 1; i < max; i++) {  
		        buckets[i] = buckets[i] + buckets[i - 1];  
		    }  
		    // 将data中的元素完全复制到tmp数组中  
		    System.arraycopy(data, 0, tmp, 0, data.length);  
		    // 根据buckets数组中的信息将待排序列的各元素放入相应位置  
		    for (int k = data.length - 1; k >= 0; k--) {  
		         data[--buckets[tmp[k]]] = tmp[k];  
		    }  
		    
		}
		
		/**
		 * 利用类似散列的结构解决桶排序
		 * @param data
		 * @param min
		 * @param max
		 */
		public static void bucketSort3(int[] data,int min,int max) {
			
			System.out.println(max+"\t"+min);
			
			//构造桶
			//桶数量
			int bucketNum = (max - min) / data.length + 1;
			//每个桶是一个ArrayList
			ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
			//相当于有一个横向数组，每一个横向数组下标是一个ArrayList的散列结构
			for(int i = 0;i<bucketNum;i++) {
				 bucketArr.add(new ArrayList<Integer>());
			}
			
			 //将每个元素放入桶
		    for(int i = 0; i < data.length; i++){
		    	//元素所在的横向数组下标，根据下标进入指定的ArrayList,解决重复数据问题
		        int num = (data[i] - min) / (data.length);
		        bucketArr.get(num).add(data[i]);
		    }
		    
		    //对每个桶进行排序
		    for(int i = 0; i < bucketArr.size(); i++){
		        Collections.sort(bucketArr.get(i));
		    }
		   
		    System.out.println(bucketArr.toString());
		}
		
		
		
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
		 * 获取待排序数组的最小值
		 * @param array
		 * @return
		 */
		private static int getMin(int[] array){
			
			int min = array[0];
			for(int i = 1;i<array.length;i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			return min;
		}
		
		/**
		 * 计数排序
		 * @param array
		 */
		private static void countSort(int[] data) {
			
			// 得到最大最小值
			int max = getMax(data);
			int min = getMin(data);
			// 得到辅助数组来存储data数组每一元素出现的次数
			// data数组中每一个数和最小值的差是一定的，这一步有排序的作用
			int[] help = new int[max - min + 1];
			for (int i = 0; i < data.length; i++) {
				int mapPos = data[i] - min;
				help[mapPos]++;
			} 
			// 查看help数组
			System.out.println(Arrays.toString(help));
			int k = 0;
			// 得到输出数组
			for (int i = 0; i < help.length; i++) {
				//根据help数组中存的次数去取排列好的元素
				while (help[i] != 0) {
					data[k] = min + i;
					k++;
					help[i]--;
				}
			}
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] a = {1,8,2,6,4,2,3,8,4,6,10,12,45,21,31,22,22,22,23,21,20,23,24,21,23,23};
			System.out.println(a.length);
			/*
			//桶排序1
			bucketSort(a,0,getMax(a)+1);
			for(int i = 0;i<a.length;i++) {	
				System.out.print(a[i]+"\t");
			}
			
			System.out.println("\n");
			
			//桶排序2
			bucketSort(a, getMax(a));
			for(int i = 0;i<a.length;i++) {
			//	if(a[i]>0)
					//System.out.print(a[i]+"\t");
			}
			bucketSort3(a,getMin(a),getMax(a));
			*/
			countSort(a);
			for(int i = 0;i<a.length;i++) {	
				System.out.print(a[i]+"\t");
			}
			
		}

}
