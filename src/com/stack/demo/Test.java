package com.stack.demo;
/**
*@author caikeren
*@version 2019年4月12日上午1:15:57
*/
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack();
		stack.pushMinStack(12);
		stack.pushMinStack(13);
		stack.pushMinStack(21);
		stack.pushMinStack(15);
		System.out.println(stack.getMin(stack));
	}

}
