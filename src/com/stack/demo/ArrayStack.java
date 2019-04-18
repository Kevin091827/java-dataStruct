package com.stack.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description:    自定义栈（数组实现）
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:32
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:32
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class ArrayStack {

	private int[] stack;
	
	//默认分配空间
	private static int DEFAULT_SIZE  = 10;
	
	//当前元素的数量
	private int currentCount;
	
	public ArrayStack() {
		stack = new int[DEFAULT_SIZE];
		currentCount = 0;
	}
	
	public ArrayStack(int size) {
		stack = new int[size];
	}
	
	/**
	 * 返回当前栈元素数量
	 * @return
	 */
	public int getSize() {
		return currentCount;
	}
	
	/**
	 * 入栈
	 * @param element
	 * @return
	 */
	public boolean push(int element) {
		
		if(currentCount == stack.length)
			return false;
		else {
			stack[getSize()] = element;
			currentCount++;
			return true;
		}
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		
		int result;
		if(currentCount == 0)
			throw new RuntimeException();
		else {
			result = stack[getSize()-1];
			currentCount--;
			return result;
		}
	}
	
	/**
	 * 获取栈顶元素
	 * @return
	 */
	public int getTop() {
		return stack[getSize()];
	}
	
	private ArrayStack minStack;


	/**
	 * 获取栈中的最小值
	 * @param value
	 * @return
	 */
	public void pushMinStack(int value) {

		minStack = new ArrayStack();
		if (minStack.getSize() == 0) {
			minStack.push(value);
		}else {
			int min = minStack.getTop();
			if(min >= value) {
				minStack.push(value);
			}
		}
	}
	
	
	/**
	 * 获取栈中最小值
	 * @param stack
	 * @return
	 */
	public int getMin(ArrayStack stack) {
		
		return minStack.getTop();
	}
	
}
