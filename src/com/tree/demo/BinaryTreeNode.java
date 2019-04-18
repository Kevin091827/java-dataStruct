package com.tree.demo;

/**
 * @Description:    二叉树节点类
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:33
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:33
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinaryTreeNode {

	//值
	private int value;
	//左子节点
	private BinaryTreeNode left;
	//右子节点
	private BinaryTreeNode right;

	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
}
