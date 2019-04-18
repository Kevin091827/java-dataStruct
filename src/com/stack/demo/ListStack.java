package com.stack.demo;
/**
 * @Description:    自定义栈（链表实现）
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:32
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:32
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class ListStack {

	class ListNode{
		
		//节点数据值
		int value;
		
		//指向下一节点的next指针
		ListNode next;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
		
		public ListNode(int value,ListNode next) {
			this.value = value;
			this.next = next;
		}
		
	}
	
	//指向栈顶元素的top指针
	private ListNode top;
	
	/**
	 * 入栈
	 * @param value
	 */
	public void push(int value) {
		ListNode listNode = new ListNode(value,null);
		if(top == null) {
			top = listNode;
		}else {
			listNode.next = top;
			top = listNode;
		}
	}
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		int result;
		if(top == null) {
			throw new RuntimeException();
		}else {
			result = top.value;
			top = top.next;
			return result;
		}
	}
	
	/**
	 * 获取栈顶元素
	 * @return
	 */
	public int getTop() {
		return top.value;
	}
}
