package com.tree.demo;

/**
 * @Description:    节点类
 * @Author:         Kevin
 * @CreateDate:     2019/7/24 0:13
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/7/24 0:13
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinaryTreeNode {

    //节点值
    private int element;
    //左子节点
    private BinaryTreeNode left;
    //右子节点
    private BinaryTreeNode right;

    public BinaryTreeNode(int element,BinaryTreeNode left,BinaryTreeNode right){

        this.element = element;
        this.right = right;
        this.left = left;
    }

    public BinaryTreeNode(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
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
