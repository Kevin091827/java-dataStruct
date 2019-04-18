package com.heap.demo;

import org.omg.CORBA.Any;

/**
 * @Description:    堆
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:30
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:30
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>>{

	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int currentSize;
	
	private AnyType[] array;

	public BinaryHeap(AnyType[] array) {
		super();
		this.array = array;
	}

	/**
	 * 构建堆
	 */
	public BinaryHeap() {
		for(int i = currentSize/2;i>0;i--) {
			percolateDown(i);
		}
	}
	
	private void enlargeArray(int newSize) {
		
	}
	
	/**
	 * 向堆中插入元素  ---- 上滤 ---- O(logN)
	 * @param x
	 */
	private void insert(AnyType x) {
		
		//判断当前堆（数组）是否已满，满则扩容，防止数组越界
		if(currentSize == array.length -1)
			enlargeArray(array.length * 2 + 1);
		
		//将要插入的元素放在最后一个叶子节点，即数组最后一个元素的位置
		int hole = ++currentSize;
		
		//父节点 ：hole / 2 
		//左子节点：2*hole
		//右子节点：2*hole+1
		//x和父节点比较，比父节点大则上滤，原父节点下滤
		for(array[0] = x ;x.compareTo(array[hole/2]) < 0 ; hole/=2) {
			array[hole] = array[hole / 2];
		}
		//最后再将要插入的值赋值过去符合的节点处
		array[hole] = x;
	}
	
	
	/**
	 * 下滤 ---- O(logN)
	 * @param hole
	 */
	private void percolateDown(int hole) {
		
		int child;
		AnyType tmp = array[hole];
		
		for(; hole * 2 <= currentSize;hole = child) {
				
			child = hole * 2;
			//左子节点>右子节点
			if(array[child].compareTo(array[child+1]) < 0)
				//转向右子节点
				child++;
			//左子节点小于父节点
		    if(array[child].compareTo(tmp) < 0)
				//左子节点称为新的父节点
				array[hole] = array[child];
			else 
				break;
			
		}
		//完成交换
		array[hole] = tmp;
		
	}
	
}
