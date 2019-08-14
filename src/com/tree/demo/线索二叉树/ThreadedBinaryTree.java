package com.tree.demo.线索二叉树;


/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:ThreadedBinaryTree
 * @Description: 线索二叉树
 */
public class ThreadedBinaryTree {

    //遍历序列的前驱节点
    private ThreadedTreeNode preNode;

    //根节点
    private ThreadedTreeNode root;

    public ThreadedTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedTreeNode root) {
        this.root = root;
    }

    /**
     * 中序线索化
     * @param node
     */
    public void inThreadOrder(ThreadedTreeNode node){
        if(node == null){
            return;
        }
        //递归线索化左子树
        inThreadOrder(node.left);
        //此时 node节点的左右标志位均为false，代表的左右子节点
        //如果左子节点为空
        if(node.left == null){
            //赋值为遍历序列的前驱节点
            node.left = preNode;
            //设置标志位
            node.leftIsThreaded = true;
        }
        //同样道理处理遍历序列的前驱的节点的后继节点为node节点
        if(preNode != null && preNode.right == null){
            preNode.right = node;
            preNode.rightIsThread = true;
        }
        preNode = node;
        //递归线索化右子节点
        inThreadOrder(node.right);
    }

    /**
     * 前序线索化二叉树
     * @param node
     */
    public void preThreadOrder(ThreadedTreeNode node){
        if(node == null){
            return;
        }

        //此时 node节点的左右标志位均为false，代表的左右子节点
        //如果左子节点为空
        if(node.left == null){
            //赋值为遍历序列的前驱节点
            node.left = preNode;
            //设置标志位
            node.leftIsThreaded = true;
        }
        //同样道理处理遍历序列的前驱的节点的后继节点为node节点
        if(preNode != null && preNode.right == null){
            preNode.right = node;
            preNode.rightIsThread = true;
        }
        preNode = node;
        //递归线索化左子树
        if(!node.leftIsThreaded){
            inThreadOrder(node.left);
        }
        //递归线索化右子节点
        if(!node.rightIsThread) {
            inThreadOrder(node.right);
        }
    }

    /**
     * 前序遍历线索二叉树
     * @param node
     */
    public void preOrder(ThreadedTreeNode node){
        if(node == null){
            return;
        }
        //不断寻找前驱，找到第一个
        while(node != null){
            if(!node.leftIsThreaded){
                node = node.left;
            }
        }
        //遍历
        System.out.println(node.val);
        node = node.right;
    }

    /**
     * 中序遍历线索二叉树
     * 【morris算法】
     * @param node
     */
    public void inOrder(ThreadedTreeNode node){
        if(node == null){
            return;
        }
        //1、找最后一个节点，当前标志位均为false
        while(node.right != null && !node.rightIsThread) {
            node = node.right;
        }
        while(node != null){
            //遍历
            System.out.println(node.val);
            //判断是否是线索
            if(!node.leftIsThreaded){
                //是线索，继续往前遍历
                node = node.left;
            }else{
                //不是线索,找到左子树开始的节点
                node = node.left;
                while(!node.rightIsThread && node.right != null){
                    node = node.right;
                }
            }
        }
    }
}
