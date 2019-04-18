package com.heap.demo;
/**
 * @Description:    左式堆
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:30
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:30
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class LeftHeap<AnyType extends Comparable<? super AnyType>>{
	
	private static class Node<AnyType>{
		
		AnyType element;
		Node<AnyType> root;
		Node<AnyType> left;
		Node<AnyType> right;
		int npl;
		public Node(AnyType element) {
			super();
			this.element = element;
		}
		public Node(AnyType element, Node<AnyType> left, Node<AnyType> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
			this.npl = 0;
		}
 	}
	
	/**
	 * 合并堆（递归实现）
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge(Node<AnyType> h1,Node<AnyType> h2){
		
		//如果合并的两堆中，有一个是空堆，则不需要合并，直接返回非空堆
		if(h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		//将具有较大根值的堆和较小根值的堆的右子堆合并
		if(h1.element.compareTo(h2.element)<0) {
			return merge1(h1, h2);
		}else {
			return merge1(h2, h1);
		}
	}
	
	/**
	 * 合并堆 （递归实现）---O(logN)（真正实现堆的合并操作）
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge1(Node<AnyType> h1,Node<AnyType> h2){
		
		//h1是较小根值的堆，h2是较大根植的堆长
		//如果h1的左子堆是空堆，则左子堆的零路径长<右子堆，不满足左子堆零路径>右子堆，所以，直接将h2合并到h1左子堆
		if(h1.left == null) {
			h1.left = h2;
		}else {
			//否则，则将较大根值得堆合并到较小根值的堆的右子堆
			h1.right = merge(h1.right, h2);
			//比较合并后的左右子堆的零路经长是否满足左子堆零路径>右子堆
			//不满足则交互左右堆
			if(h1.left.npl < h1.right.npl) {
				swapChild(h1);
			}
			h1.npl = h1.right.npl+1;
		}
		return h1;
	}
	
	/**
	 * 交换左右孩子
	 * @param t
	 */
	private void swapChild(Node<AnyType> t) {
		
	}

}
