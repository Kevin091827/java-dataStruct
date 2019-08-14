package com.tree.demo.二叉搜索树;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:    二叉搜索树
 * @Author:         Kevin
 * @CreateDate:     2019/7/25 16:09
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/7/25 16:09
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>>{

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * 内部节点类
     * @author
     * @param <T>
     */
    private static class Node<T>{

        T element;
        Node<T> root;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            super();
            this.element = element;
        }
        public Node(T element, Node<T> left, Node<T> right) {
            super();
            this.element = element;
            this.left = left;
            this.right = right;
        }
        public T getElement() {
            return element;
        }
        public void setElement(T element) {
            this.element = element;
        }
        public Node<T> getRoot() {
            return root;
        }
        public void setRoot(Node<T> root) {
            this.root = root;
        }
        public Node<T> getLeft() {
            return left;
        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public Node<T> getRight() {
            return right;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    /**
     * 构造二叉树
     * 【递归】
     * @param x
     * @param t
     * @return
     */
    public Node<T> insert(T x,Node<T> t){
        if(t == null){
            return new Node<T>(x,null,null);
        }
        int result = x.compareTo(t.element);
        if(result < 0){
            t.left = insert(x,t.getLeft());
        }else if(result > 0){
            t.right = insert(x,t.getRight());
        }else{
            t.element = x;
        }
        return t;
    }

    /**
     * 判断是否包含指定节点
     * @param x
     * @param node
     * @return
     */
    public boolean contain(T x,Node node){
        if(node == null){
            return false;
        }
        int result = x.compareTo((T)node.getElement());
        if(result < 0){
            return contain(x,node.getLeft());
        }else if(result > 0){
            return contain(x,node.getRight());
        }else {
            return true;
        }
    }

    /**
     * 前序遍历
     * 【递归实现】
     * @param root
     */
    public void preOrder(Node root){
        if(root != null){
            System.out.println(root.getElement());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 前序遍历
     * 【非递归实现】
     * @param root
     */
    public void preOrder2(Node root){
        if(root == null){
            return;
        }
        ArrayList<T> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add((T) node.getElement());
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
        for(T i : list){
            System.out.println(i);
        }
    }

    /**
     * 中序遍历
     * 【递归实现】
     * @param root
     */
    public void inOrder(Node root){
       if(root != null){
           inOrder(root.getLeft());
           System.out.println(root.element);
           inOrder(root.getRight());
       }
    }

    /**
     * 中序遍历
     * 【非递归实现】
     * @param root
     */
    public void inOrder2(Node root){
        if(root == null){
            return;
        }
        ArrayList<T> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.getLeft();
            }else {
                root = stack.pop();
                list.add((T)root.element);
                root = root.getRight();
            }
        }
        for(T i : list){
            System.out.println(i);
        }
    }

    /**
     * 后序遍历
     * 【递归实现】
     * @param root
     */
    public void proOrder(Node root){
        if(root != null){
            proOrder(root.getLeft());
            proOrder(root.getRight());
            System.out.println(root.getElement());
        }
    }

    /**
     * 后序遍历
     * 【非递归实现】
     * @param root
     */
    public void proOrder2(Node root){
        if(root == null){
            return ;
        }
        ArrayList<T> resultList = new ArrayList<>();
        //操作栈
        Stack<Node> stack = new Stack<>();
        //结果栈，用于存放后序遍历的结果
        Stack<Node> resultStack = new Stack<>();
        Node p = root;
        while(!stack.isEmpty() || p != null){
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
            Node node = resultStack.pop();
            resultList.add((T) node.element);
        }
        for(T i : resultList){
            System.out.println(i);
        }
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void breathFirst(Node root){
        if(root == null){
            return;
        }
        ArrayList<T> resultList = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
            while(!queue.isEmpty()){
                root = queue.remove();
                resultList.add((T) root.getElement());
                if(root.getLeft() != null){
                    queue.add(root.getLeft());
                }
                if(root.getRight() != null){
                    queue.add(root.getRight());
                }
            }
        }
        for(T i : resultList){
            System.out.println(i);
        }
    }

    /**
     * 删除指定节点
     * @param x
     * @param root
     * @return
     */
    public Node remove(T x,Node root){
        Node<Integer> temp;
        //没有要删除的元素，因为这是空树
        if(root == null) {
            return null;
        }
        int result = x.compareTo((T) root.element);
        if(result < 0) {
            //左子树递归删除
            root.left = remove(x, root.left);
        }else if (result > 0) {
            //右子树递归删除
            root.right = remove(x, root.right);
        }else {
            //找到要删除的元素
            //要删除元素有两个节点的情况
            if (root.left!=null && root.right!=null) {
                //在右子树中找出最小的节点填充删除的节点
                //root.element = findMin(root.right).element;
                temp= findMin(root.right);
                //在删除节点的右子树中删除最小元素，即刚刚填充的元素
                root.right = remove((T)root.element, root.right);
            }else {
                //单节点情况
                temp = root;
                //root = (root.left != null)?root.left:root.right;
                if(root.left == null) {
                    root = root.right;
                }else if (root.right == null) {
                    root = root.left;
                }else {
                    temp = null;
                }
            }
        }
        return root;
    }


    /**
     * 找出最大节点
     * @param node
     * @return
     */
    public Node findMax(Node node){
        Node maxNode = null;
        while(node != null){
            maxNode = node;
            node = node.right;
        }
        return maxNode;
    }

    /**
     * 找到最小节点
     * @param node
     * @return
     */
    public Node findMin(Node node){
        Node minNode = null;
        while(node != null){
            minNode = node;
            node = node.left;
        }
        return minNode;
    }


    public static void main(String[] args) {
        System.out.println("*******构造二叉查找树*******");
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        Node root = new Node<Integer>(12);
        binarySearchTree.setRoot(root);
        binarySearchTree.insert(10, root);
        binarySearchTree.insert(13, root);
        binarySearchTree.insert(11,root);
        binarySearchTree.insert(15, root);
//        System.out.println("是否包含指定节点：------------>>>>"
//                +binarySearchTree.contain(15,root));
//        binarySearchTree.preOrder(root);
//        binarySearchTree.preOrder2(root);
//        System.out.println("最大节点：-----------> "+ binarySearchTree.findMax(root).element);
//        System.out.println("最大节点：-----------> "+ binarySearchTree.findMin(root).element);
        //删除前
        binarySearchTree.remove(15,root);
        //删除后
//        System.out.println("最大节点：-----------> "+ binarySearchTree.findMax(root).element);
//        binarySearchTree.inOrder(root);
//        binarySearchTree.inOrder2(root);
        binarySearchTree.proOrder(root);
        binarySearchTree.proOrder2(root);
    }
}
