package com.tree.demo.线索二叉树;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:ThreadedTreeNode
 * @Description: TODO
 */
public class ThreadedTreeNode {

    public int val;
    public ThreadedTreeNode left;
    public ThreadedTreeNode right;
    //标记位
    //当为true时，指向遍历序列的前驱节点
    public boolean leftIsThreaded;
    //当为true时，指向遍历序列的后继节点
    public boolean rightIsThread;

    public ThreadedTreeNode(int val) {
        this.left = null;
        this.right = null;
        this.leftIsThreaded = false;
        this.rightIsThread = false;
        this.val = val;
    }
}
