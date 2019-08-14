package com.tree.demo.二叉树实现;

import com.tree.demo.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:    二叉树
 * @Author:         Kevin
 * @CreateDate:     2019/7/24 0:11
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/7/24 0:11
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinaryTree {

    //根节点
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历 --- 递归实现
     * @param root
     */
    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.getElement());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 前序遍历 --- 非递归实现
     * @param root
     */
    public void preOrder2(BinaryTreeNode root){
        BinaryTreeNode p = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        if(p == null){
           return;
        }
        stack.push(p);
        while(!stack.isEmpty()){
            BinaryTreeNode node = stack.pop();
            int element = node.getElement();
            resultList.add(element);
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
        for(int i : resultList){
            System.out.println(i);
        }
    }

    /**
     * 中序遍历 --- 递归实现
     * @param root
     */
    public void inOrder(BinaryTreeNode root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getElement());
            inOrder(root.getRight());
        }
    }

    /**
     * 中序遍历 --- 非递归实现
     * @param root
     */
    public void inOrder2(BinaryTreeNode root){

        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        while(p != null || !stack.isEmpty()){
            if(p != null){
               stack.push(p);
               p = p.getLeft();
            }else {
                p = stack.pop();
                resultList.add(p.getElement());
                p = p.getRight();
            }
        }
        for(int i : resultList){
            System.out.println(i);
        }
    }

    /**
     * 后序遍历 --- 递归实现
     * @param root
     */
    public void proOrder(BinaryTreeNode root){
        if(root != null){
            proOrder(root.getLeft());
            proOrder(root.getRight());
            System.out.println(root.getElement());
        }
    }

    /**
     * 后序遍历 --- 非递归实现
     * @param root
     */
    public void proOrder2(BinaryTreeNode root){
        ArrayList<Integer> resultList = new ArrayList<>();
        BinaryTreeNode p = root;
        //操作栈
        Stack<BinaryTreeNode> stack = new Stack<>();
        //结果栈，用于存放后序遍历的结果
        Stack<BinaryTreeNode> resultStack = new Stack<>();
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                resultStack.push(p);
                p = p.getRight();
            }else{
                p = stack.pop();
                p = p.getLeft();
            }
        }
        while(!resultStack.isEmpty()){
            BinaryTreeNode node = resultStack.pop();
            resultList.add(node.getElement());
        }
        for(int i : resultList){
            System.out.println(i);
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void breathFirst(BinaryTreeNode root){
        if(root == null){
            return;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
            while(!queue.isEmpty()){
                root = queue.remove();
                resultList.add(root.getElement());
                if(root.getLeft() != null){
                    queue.add(root.getLeft());
                }
                if(root.getRight() != null){
                    queue.add(root.getRight());
                }
            }
        }
        for(int i : resultList){
            System.out.println(i);
        }
    }

    /**
     * <h>计算二叉树深度</h>
     *
     * <li>1、一颗树只有一个节点，它的深度是 1</li>
     *
     * <li>2、二叉树的根节点只有左子树而没有右子树，二叉树的深度应该是其左子树的深度加 1</li>
     *
     * <li>3、二叉树的根节点只有右子树而没有左子树，那么二叉树的深度应该是其右树的深度加 1</li>
     *
     * <li>4、二叉树的根节点既有右子树又有左子树，那么二叉树的深度应该是其左右子树的深度较大值加 1</li>
     *
     * 【递归实现】
     * @return
     */
    public int depthOfBinaryTree(BinaryTreeNode root){
        if(root == null){
            return 0;
        }else{
            return Math.max(depthOfBinaryTree(root.getLeft()),depthOfBinaryTree(root.getRight()))+1;
        }
    }


    /**
     * <h>计算二叉树深度</h>
     *
     * 【非递归实现】
     *
     * @param root
     * @return
     */
    public int depthOfBinaryTree2(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                BinaryTreeNode node = queue.removeFirst();
                if(node.getLeft() != null){
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null){
                    queue.add(node.getRight());
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 计算二叉树的节点数
     * 【递归】
     * @param root
     * @return
     */
    public int nodeNum(BinaryTreeNode root){
        if(root == null){
            return 0;
        }else{
            //根节点 + 根左子树的节点数 + 根右子树的节点数
            return 1+nodeNum(root.getRight())+nodeNum(root.getLeft());
        }
    }


    /**
     * 镜像二叉树
     * 【递归实现】
     * @param root
     */
    public void mirror(BinaryTreeNode root){
        if(root != null &&(root.getLeft() != null || root.getRight() != null)){
            //交换左右节点
            BinaryTreeNode left = root.getLeft();
            BinaryTreeNode right = root.getRight();
            BinaryTreeNode tmp = root.getLeft();
            left = root.getRight();
            right = tmp;
            //递归镜像左右子树
            mirror(root.getLeft());
            mirror(root.getRight());
        }
        return ;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(15);
        BinaryTreeNode r1 = new BinaryTreeNode(4);
        BinaryTreeNode r2 = new BinaryTreeNode(1);
        BinaryTreeNode r3 = new BinaryTreeNode(20);
        BinaryTreeNode r4 = new BinaryTreeNode(16);
        BinaryTreeNode r5 = new BinaryTreeNode(25);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        root.setLeft(r1);
        root.setRight(r3);
        r1.setLeft(r2);
        r3.setLeft(r4);
        r3.setRight(r5);
//        System.out.println("********前序遍历递归**********");
//        binaryTree.preOrder(root);
//        System.out.println("********前序遍历非递归**********");
//        binaryTree.preOrder2(root);
//        System.out.println("********中序遍历递归**********");
//        binaryTree.inOrder(root);
//        System.out.println("********中序遍历非递归**********");
//        binaryTree.inOrder2(root);
//        System.out.println("********后序遍历递归**********");
//        binaryTree.proOrder(root);
//        System.out.println("********后序遍历非递归**********");
//        binaryTree.proOrder2(root);
//        System.out.println("********层序遍历非递归**********");
//        binaryTree.breathFirst(root);
//        int depth = binaryTree.depthOfBinaryTree(root);
//        System.out.println("二叉树深度： ------》"+depth);
//        int depth2 = binaryTree.depthOfBinaryTree2(root);
//        System.out.println("二叉树深度： ------》"+depth2);
//        int nodeNum = binaryTree.nodeNum(root);
//        System.out.println("二叉树的节点数：----》"+nodeNum);
          binaryTree.mirror(root);
    }
}
