package com.tree.demo;

/**
 * @Description:    平衡树节点类
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:33
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:33
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class AvlNode<Anytype extends Comparable> {
	
	/**
	 * Avl树，节点类
	 */
	
	Anytype element;
	AvlNode<Anytype> right;
	AvlNode<Anytype> left;
	int hight;
	
	public AvlNode(Anytype element) {
		super();
		this.element = element;
		this.right = null;
		this.left = null;
	}
	
	public AvlNode(Anytype element, AvlNode<Anytype> right, AvlNode<Anytype> left, int hight) {
		super();
		this.element = element;
		this.right = right;
		this.left = left;
		this.hight = hight;
	}
	
	private static final int ALLOW_IMBALANCE = 1;
	
	/**
	 * Avl树的高度，默认根节点高度是-1
	 * @param t
	 * @return
	 */
	private int hight(AvlNode<Anytype> t) {
		return t == null ? -1 : t.hight;
	}
	
	/**
	 * 插入节点
	 * @param x
	 * @param t
	 * @return
	 */
	private AvlNode<Anytype> insert(Anytype x,AvlNode t){
		if(t == null){
			return new AvlNode(x);
		}
		int result = x.compareTo(t);
		if(result<0) {
			t.left = insert(x, t.left);
		}else if(result>0) {
			t.right = insert(x, t.right);
		}else
			;
		return balance(t);
	}
	
	
	/**
	 * 在插入新节点后判断树结构是否平衡，不平衡则平衡树
	 * @param t
	 * @return
	 */
	private AvlNode<Anytype> balance(AvlNode<Anytype> t) {
		
		if(t==null) {
			return t;
		}
		if(hight(t.left)-hight(t.right)>ALLOW_IMBALANCE) {
			if(hight(t.left) >= hight(t.right))
				rotateWithLeftChild(t);
			else
				doubleWithLeftChild(t);
		}
		if(hight(t.right)-hight(t.left)>ALLOW_IMBALANCE) {
			if(hight(t.right) >= hight(t.left))
				rotateWithRightChild(t);
			else
				doubleWithRightChild(t);
		}
		
		t.hight = Math.max(hight(t.left), hight(t.right))+1;
		return t;
		
	}

	
	/**
	 * 左 双旋转
	 * @param t
	 */
	private AvlNode<Anytype> doubleWithLeftChild(AvlNode<Anytype> k2) {
		// TODO Auto-generated method stub
		k2.left = rotateWithLeftChild(k2.left);
		return rotateWithRightChild(k2);
	}

	
	/**
	 * 右 单旋转
	 * @param t
	 */
	private AvlNode<Anytype> rotateWithRightChild(AvlNode<Anytype> k2) {
		// TODO Auto-generated method stub
		AvlNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		
		k2.hight = Math.max(hight(k2.right), hight(k2.left))+1;
		k1.hight = Math.max(hight(k1.left), hight(k2))+1;
		
		return k1;
	}

	/**
	 * 右 双旋转
	 * @param t
	 */
	private AvlNode<Anytype> doubleWithRightChild(AvlNode<Anytype> k2) {
		// TODO Auto-generated method stub
		k2.left = rotateWithRightChild(k2.left);
		return rotateWithLeftChild(k2);
	}

	
	/**
	 * 左 单旋转
	 * @param t
	 */
	private AvlNode<Anytype> rotateWithLeftChild(AvlNode<Anytype> k2) {
		// TODO Auto-generated method stub
		AvlNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.hight = Math.max(hight(k2.right), hight(k2.left))+1;
		k1.hight = Math.max(hight(k1.right), hight(k2))+1;
		
		return k1;
	}
	
	
}
