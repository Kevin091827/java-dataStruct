package com.tree.demo.平衡树;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: Kevin
 * @Date:
 * @ClassName:AvlTree
 * @Description: TODO
 */
public class AvlTree {

    private AvlNode root;

    public AvlNode getRoot() {
        return root;
    }

    public void setRoot(AvlNode root) {
        this.root = root;
    }

    /**
     * 构建平衡树
     * @param x
     * @param root
     * @return
     */
    public AvlNode insert(int x,AvlNode root){
        if(root == null){
            return new AvlNode(null,null,x);
        }
        if(x > root.val){
            root.right = insert(x,root.right);
        }else if(x < root.val){
            root.left = insert(x,root.left);
        }else{
            root.val = x;
        }
       return balance(root);
    }

    /**
     * 删除平衡树中的指定节点
     * @param x
     * @param root
     * @return
     */
    public AvlNode remove(int x,AvlNode root){
        if(root == null){
            return root;
        }
        //寻找指定节点
        if(x > root.val){
            root.right = remove(x,root.right);
        }else if(x < root.val){
            root.left = remove(x,root.left);
        }else{
            //找到了指定节点
            //判断是否存在子节点，以及是单个子节点还是两个子节点
            if(root.left != null && root.right != null){
                //左右子节点都存在
                //找出右子树中的最小值
                root.val = findMin(root.right).val;
                //转成一个子节点的情况
                root.right = remove(root.val,root.right);
            }else{
                //存在一个子节点,不空则覆盖
                if(root.left != null){
                    root = root.left;
                }
                else if(root.right != null){
                    root = root.right;
                }
                //叶节点情况
                else {
                    root = null;
                }
            }
        }
        //重新平衡
        return balance(root);
    }

    /**
     * 找出最大节点
     * @param node
     * @return
     */
    public AvlNode findMax(AvlNode node){
        AvlNode maxNode = null;
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
    public AvlNode findMin(AvlNode node){
        AvlNode minNode = null;
        while(node != null){
            minNode = node;
            node = node.left;
        }
        return minNode;
    }

    /**
     * 求平衡树深度
     * @param root
     * @return
     */
    public int depth(AvlNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(depth(root.left),depth(root.right))+1;
        }
    }

    /**
     * 平衡树结构
     * @param root
     */
    private AvlNode balance(AvlNode root) {
        if(root == null){
            return root;
        }
        //新节点插入的左子树
        if (hight(root.left) - hight(root.right) > 1){
            //新节点插入的左子树的左子节点
            if(hight(root.left.left) >= hight(root.left.right)){
                //右旋
                root = rightBalance(root);
            }else{
                //新节点插入的是左子树的右子节点
                //先左旋后右旋
                root = doubleLeftThenRight(root);
            }
        }
        //新节点插入的右子树
        else
        if(hight(root.right) - hight(root.left) > 1){
            //新节点插入的是右子树的右子节点
            if(hight(root.right.right) >= hight(root.right.left)){
                //左旋
                root = leftBalance(root);
            }else{
                //新节点插入的右子树的左子节点
                //先右旋后左旋
                root = doubleRightThenLeft(root);
            }
        }
        //高度重置
        root.hight = Math.max(hight(root.left),hight(root.right))+1;
        return root;
    }

    /**
     * 求当前节点高度
     * @param k
     * @return
     */
    private int hight(AvlNode k){
        return k == null ? -1 : k.hight;
    }

    /**
     * 单旋 --- 左旋
     *
     * 适用情况：
     *          1.新插入节点是右子树的右子节点
     *          2.右子树的右子节点高度 >= 右子树左子节点的高度
     * @return
     */
    private AvlNode leftBalance(AvlNode root){
        //左旋掕右左挂右
        AvlNode node = root.right;
        //拎起来的节点的左子树挂到原来节点的右子树
        root.right = node.left;
        node.left = root;

        //高度重置
        root.hight = Math.max(hight(root.left),hight(root.right))+1;
        node.hight = Math.max(hight(node.right),hight(root))+1;

        return node;
    }

    /**
     * 单旋 --- 右旋
     *
     * 使用情况：
     *          1.新插入节点是左子树的左子节点
     *          2.左子树的左子节点的高度 >= 左子树右子节点的高度
     *
     * @param root
     * @return
     */
    private AvlNode rightBalance(AvlNode root){
        //右旋掕左右挂左
        AvlNode node = root.left;
        root.left = node.right;
        node.right = root;

        //高度重置
        root.hight = Math.max(hight(root.left),hight(root.right))+1;
        node.hight = Math.max(hight(node.left),hight(root))+1;

        return node;
    }

    /**
     * 双旋 --- 先左旋后右旋
     *
     * 适用情况：
     *         1.新插入节点是左子树的右子节点
     *         2.左子树左子节点高度 <= 左子树右子节点高度
     * @param root
     * @return
     */
    private AvlNode doubleLeftThenRight(AvlNode root){
        //左旋
        root.left = leftBalance(root.left);
        //右旋
        return rightBalance(root);
    }

    /**
     * 双旋 --- 先右旋后左旋
     *
     * 适用情况：
     *          1.新插入节点是右子树的左子节点
     *          2.右子树的左子节点高度 >= 右子树右子节点高度
     * @param root
     * @return
     */
    private AvlNode doubleRightThenLeft(AvlNode root){
        //右旋
        root.right = rightBalance(root.right);
        //左旋
        return leftBalance(root);
    }

    /**
     * 中序遍历
     * 【递归实现】
     * @param root
     */
    public void inOrder(AvlNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 前序遍历
     * 【非递归实现】
     * @param root
     */
    public void preOrder(AvlNode root){
        if(root == null){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<AvlNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        for(int i : list){
            System.out.println(i);
        }
    }


    /**
     * 中序遍历
     *【非递归实现】
     * @param root
     */
    public void inOrder2(AvlNode root){
        if(root == null){
            return;
        }
        Stack<AvlNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
               stack.push(root);
               root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        for(int i : list){
            System.out.println(i);
        }
    }

    /**
     * 后序遍历
     * 【非递归实现】
     * @param root
     */
    public void proOrder(AvlNode root){
        if(root == null){
            return;
        }
        Stack<AvlNode> stack = new Stack<>();
        Stack<AvlNode> resultStack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                resultStack.push(root);
                root = root.right;
            }else {
                root = stack.pop();
                root = root.left;
            }
        }
        while(!resultStack.isEmpty()){
            System.out.println(resultStack.pop().val);
        }
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public void breathFirst(AvlNode root){
       if(root == null){
           return;
       }
       ArrayList<Integer> resultList = new ArrayList<>();
       Queue<AvlNode> queue = new ArrayDeque<>();
       if(root != null){
           queue.add(root);
           while(!queue.isEmpty()){
               root = queue.remove();
               resultList.add(root.val);
               if(root.left != null){
                   queue.add(root.left);
               }
               if(root.right != null){
                   queue.add(root.right);
               }
           }
       }
       for(int i : resultList){
           System.out.println(i);
       }
    }

    public static void main(String[] args) {
        System.out.println("*******构造平衡二叉查找树*******");
        AvlNode root = new AvlNode(12);
        AvlTree avlTree = new AvlTree();
        avlTree.setRoot(root);
        avlTree.insert(10, root);
        avlTree.insert(13, root);
        avlTree.insert(11,root);
        avlTree.insert(15, root);
        avlTree.inOrder(root);
        avlTree.remove(11,root);
        avlTree.inOrder(root);
        System.out.println(avlTree.depth(root));
        avlTree.breathFirst(root);
    }
}
