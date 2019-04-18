package com.list.demo;

/**
 * TODO（未完成）
 * @Description:    自定义的链表
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:30
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:30
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public interface List {

	// 返回线性表的大小
	int size();
	
	// 返回线性表中序号为 i 的元素
	Object get(int i);
	
	// 判断线性表是否为空
	boolean isEmpty();
	
	// 判断线性表是否包含元素e
	boolean contain(Object e);
	
	// 返回e元素的序号
	int indexOf(Object e);
	
	// 在序号为i的位置添加元素e
	void add(Object e,int i);
	
	// 在线性表末尾添加元素e
	void addEnd(Object e);
	
	// 将a插入到e之前的位置
	void addBefore(Object e,Object a);
	
	// 将a插入到e之后的位置
	void addAfter(Object e,Object a);
	
	// 删除指定序号的元素
	Object remove(int i);
	
	// 删除线性表中元素是e的元素
	boolean remove(Object e);
	
	// 将序号为i的元素修改为e
	Object replace(int i,Object e);
}
