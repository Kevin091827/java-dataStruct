package com.tree.demo.平衡树;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:AvlNode
 * @Description: TODO
 */
public class AvlNode {

    AvlNode left;
    AvlNode right;
    int hight;
    int val;

    public AvlNode(AvlNode left, AvlNode right, int val) {
        this.left = left;
        this.right = right;
        this.hight = 0;
        this.val = val;
    }

    public AvlNode(int val) {
        this(null,null,val);
    }
}
