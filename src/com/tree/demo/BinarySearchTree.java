package com.tree.demo;

import java.util.ArrayList;
import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

import org.omg.CORBA.Any;

/**
 * @Description:    二叉搜索树
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:33
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:33
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
	
	private Node<AnyType> root;
	
	/**
	 * 内部节点类
	 * @author 12642
	 *
	 * @param <AnyType>
	 */
	private static class Node<AnyType>{
		
		AnyType element;
		Node<AnyType> root;
		Node<AnyType> left;
		Node<AnyType> right;
		
		public Node(AnyType element) {
			super();
			this.element = element;
		}
		public Node(AnyType element, Node<AnyType> left, Node<AnyType> right) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
		}
		public AnyType getElement() {
			return element;
		}
		public void setElement(AnyType element) {
			this.element = element;
		}
		public Node<AnyType> getRoot() {
			return root;
		}
		public void setRoot(Node<AnyType> root) {
			this.root = root;
		}
		public Node<AnyType> getLeft() {
			return left;
		}
		public void setLeft(Node<AnyType> left) {
			this.left = left;
		}
		public Node<AnyType> getRight() {
			return right;
		}
		public void setRight(Node<AnyType> right) {
			this.right = right;
		}
		
		
 	}
	
	
	/**
	 * 判断二叉查找树中是否包含指定节点
	 * @param x
	 * @param node
	 * @return
	 */
	public boolean contains(AnyType x,Node node) {
		
		if(node == null) {
			throw new RuntimeException();
		}
		
		int result = x.compareTo((AnyType) node.element);
		
		if(result<0) {
			contains(x, node.left);
		}else if(result>0) {
			contains(x, node.right);
		}else {
			return true;
		}
		return false;
	}
	
	/**
	 * 构造二叉查找树
	 * @param x
	 * @param t
	 * @return
	 */
	public Node<AnyType> insert(AnyType x,Node<AnyType> t){
		
		if(t == null)
			return new Node<AnyType>(x, null, null);
		
		int result = x.compareTo(t.element);
		
		if(result > 0)
			t.right = insert(x, t.right);
		else if(result < 0)
			t.left = insert(x, t.left);
		else {
			//dosomething
		}
		return t;
	}
	
	/**
	 * 最大节点
	 * @param root
	 * @return
	 */
	public Node<Integer> findMax(Node<Integer> root){
		
		Node<Integer> current = root;
		Node<Integer> result = null;
		while(current != null) {
			result = current;
			current = findMax(current.right);
		}
		return result;
	}
	
	/**
	 * 最小节点
	 * @param root
	 * @return
	 */
	public Node<Integer> findMin(Node<Integer> root){
		
		Node<Integer> current = root;
		Node<Integer> result = null;
		while(current != null) {
			result = current;
			current = current.left;
		}
		return result;
	}
	
	/**
	 * 中序递归遍历
	 * @param root
	 */
	private void order2(Node root) {

		if(root!=null) {		
			preOrder2(root.getLeft());
			System.out.println(root.getElement());
			preOrder2(root.getRight());
		}
	}
	
	/**
	 * 后序递归遍历
	 * @param root
	 */
	private void proOrder(Node root) {

		if(root!=null) {
			preOrder2(root.getLeft());
			System.out.println(root.getElement());
			preOrder2(root.getRight());
		}
	}
	/**
	 * 先序递归遍历
	 * @param root
	 */
	private void preOrder2(Node root) {

		if(root!=null) {
			System.out.println(root.getElement());
			preOrder2(root.getLeft());
			preOrder2(root.getRight());
		}
	}
	
	/**
	 * 查找指定节点
	 * @param data
	 * @param root
	 * @return
	 */
	public Node<Integer> getNode(AnyType data,Node<Integer> root){
		
		if(root == null) {
			return null;
		}
		
		int result = data.compareTo((AnyType) root.getElement());
		if(result < 0)
			return getNode(data, root.left);
		else if(result > 0)
			return getNode(data, root.right);
		else
			return root;
		
	}
	
	
	/**
	 * 删除指定节点
	 * @param element
	 * @param t
	 * @return
	 */
	public Node<Integer> remove(AnyType element , Node<Integer> root){
		
		Node<Integer> temp;
		//没有要删除的元素，因为这是空树
		if(root == null) {
			return null;
		}
		int result = element.compareTo((AnyType) root.element);
		if(result<0) {
			//左子树递归删除
			root.left = remove(element, root.left);
		}else if (result>0) {
			//右子树递归删除
			root.right = remove(element, root.right);
		}else {
			//找到要删除的元素
			//要删除元素有两个节点的情况
			if (root.left!=null && root.right!=null) {
				//在右子树中找出最小的节点填充删除的节点
				//root.element = findMin(root.right).element;
				temp= findMin(root.right);
				//在删除节点的右子树中删除最小元素，即刚刚填充的元素
				root.right = remove((AnyType)root.element, root.right);
			}else {
				//单节点情况			
				temp = root;
				
				//root = (root.left != null)?root.left:root.right;					
				if(root.left == null) {
					root = root.right;
				}else if (root.right == null) {
					root = root.left;
				}
				temp = null;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		
		System.out.println("*******构造二叉查找树*******");
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.root = new Node<Integer>(12);
		Node<Integer> node1 = binarySearchTree.insert(10, binarySearchTree.root);
		Node<Integer> node2 = binarySearchTree.insert(13,binarySearchTree.root );
		binarySearchTree.insert(11,node1);
		binarySearchTree.insert(15, node2);
		System.out.println("*******二叉查找树遍历*******");
		binarySearchTree.preOrder2(binarySearchTree.root);
		Node<Integer> max = binarySearchTree.findMax(binarySearchTree.root);
		Node<Integer> min = binarySearchTree.findMin(binarySearchTree.root);
		System.out.println("*******最值查找*******");
		System.out.println(max.getElement());
		System.out.println(min.getElement());
		System.out.println("*******删除指定节点*******");
		//System.out.println(binarySearchTree.remove(15, binarySearchTree.root).getElement());
		System.out.println("*******查找指定节点*******");
		System.out.println(binarySearchTree.getNode(13, binarySearchTree.root).getElement());
	}
}
