package com.tree.demo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description:    二叉树
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:33
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:33
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinaryTree {
	
	//根节点
	BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * 前序遍历非递归实现
	 * @param binaryTree
	 */
	private void preOrder(BinaryTree binaryTree) {
		
		BinaryTreeNode root = binaryTree.getRoot();
		ArrayList<Integer> list = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		if(root == null) {
			return ;
		}else {
			stack.push(root);
			while(!stack.isEmpty()) {
				BinaryTreeNode node = stack.pop();
				list.add(node.getValue());
				if(node.getRight()!=null) {
					stack.push(node.getRight());
				}
				if(node.getLeft()!=null) {
					stack.push(node.getLeft());
				}
			}
		}
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	
	/**
	 * 前序遍历递归实现
	 * @param root
	 */
	private void preOrder2(BinaryTreeNode root) {

		if(root!=null) {
			System.out.println(root.getValue());
			preOrder2(root.getLeft());
			preOrder2(root.getRight());
		}
	}
	
	/**
	 * 中序遍历非递归实现
	 * @param binaryTree
	 */
	private void order(BinaryTree binaryTree) {
		
		BinaryTreeNode root = binaryTree.getRoot();
		ArrayList<Integer> list = new ArrayList<>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				//为了能让结果list先存放的左子节点
				stack.push(root);
				root = root.getLeft();
			}else {
				root= stack.pop();
				list.add(root.getValue());
				root = root.getRight();
			}
		}
		
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	
	/**
	 * 中序遍历非递归实现
	 * @param root
	 */
	private void order2(BinaryTreeNode root) {
		if(root != null) {
			order2(root.getLeft());
			System.out.println(root.getValue());
			order2(root.getRight());
		}
	}
	
	/**
	 * 后序遍历非递归实现
	 * @param binaryTree
	 */
	private void proOrder(BinaryTree binaryTree) {
		
		BinaryTreeNode root = binaryTree.getRoot();
		ArrayList<Integer> list = new ArrayList<>();
		//操作栈
		Stack<BinaryTreeNode> stack = new Stack<>();
		//结果栈，用于存放后序遍历的结果
		Stack<BinaryTreeNode> resultStack = new Stack<>();
		
		while(root!=null || !stack.isEmpty()) {
			if(root!=null) {
				//执行完这里后，结果栈中已经从栈顶到栈底分别是：右子节点 --- 根节点
				stack.push(root);
				resultStack.push(root);
				root = root.getRight();
			}else {
				//拿到左子节点放入操作栈，重复上边操作，此时，结果栈变成了我们想要的顺序：左子节点 -- 右子节点 -- 根节点
				root = stack.pop();
				root = root.getLeft();
			}
		}
		//将遍历结果放入ArrayList中，其实本可以不使用这一步直接遍历栈，个人习惯
		while(!resultStack.isEmpty()) {
			BinaryTreeNode node = resultStack.pop();
			list.add(node.getValue());
		}
		for(Integer i : list) {
			System.out.println(i);
		}
		
	}
	
	/**
	 * 后序遍历递归实现
	 * @param root
	 */
	private void proOrder2(BinaryTreeNode root) {
		if(root!=null) {
			proOrder2(root.getLeft());
			proOrder2(root.getRight());
			System.out.println(root.getValue());
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(21);
		
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.setRoot(root);
		
		BinaryTreeNode leftNode = new BinaryTreeNode(12);
		root.setLeft(leftNode);
		
		BinaryTreeNode rightNode = new BinaryTreeNode(32);
		root.setRight(rightNode);
		
		leftNode.setLeft(new BinaryTreeNode(15));
		leftNode.setRight(new BinaryTreeNode(1));
		rightNode.setLeft(new BinaryTreeNode(4));
		rightNode.setRight(new BinaryTreeNode(5));
	
		System.out.println("********前序遍历非递归**********");
		binaryTree.preOrder2(binaryTree.root);
		System.out.println("********前序遍历递归**********");
		binaryTree.preOrder(binaryTree);
		System.out.println("********中序遍历非递归**********");
		binaryTree.order(binaryTree);
		System.out.println("********中序遍历递归**********");
		binaryTree.order2(binaryTree.root);
		System.out.println("********后序遍历非递归**********");
		binaryTree.proOrder(binaryTree);
		System.out.println("********后序遍历递归**********");
		binaryTree.proOrder2(binaryTree.root);
	}
}
