package com.hash.demo;

import java.awt.List;
import java.util.LinkedList;

/**
 * @Description:    自定义哈希表
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:30
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:30
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class MySeparateHashTable<AnyType> {
	
	// 默认哈希表大小
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	// 每一个地址对应的链表，用一个list封装一下
	private LinkedList[] theLists;
	
	private int currentSize;
	
	/**
	 * 默认的无参构造，构造指定大小的哈希表
	 */
	public MySeparateHashTable() {
		this(DEFAULT_TABLE_SIZE);
	}
	
	/**
	 * 有参构造，并实例化每个地址对应的链表
	 * @param size
	 */
	public MySeparateHashTable(int size) {
		
		theLists = new LinkedList[nextPrime(size)];
		for(int i=0;i<theLists.length;i++) {
			theLists[i] = new LinkedList<>();
		}
		
	}

	/**
	 * 获取size的下一个素数
	 * @param n
	 * @return
	 */
    private static int nextPrime(int n) {
        if( n % 2 == 0 )
            n++;
        for( ; !isPrime( n ); n += 2 );
        return n;
    }
    
    /**
     * 判断是否是素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
         if( n == 2 || n == 3 )
                return true;

         if( n == 1 || n % 2 == 0 )
                return false;

         for( int i = 3; i * i <= n; i += 2 )
               if( n % i == 0 )
                  return false;

         return true;
    }
    
    /**
     * 清空哈希表
     */
    public void makeEmpty() {
    	for(int i=0;i<theLists.length;i++) {
    		 theLists[i].clear();
    	}
		currentSize = 0;
	}
    
    /**
     * 哈希函数
     * @param key
     * @param tableSize
     * @return
     */
    public int hash3(AnyType key) {
		
		int hashVal = key.hashCode();
		
		hashVal = hashVal % theLists.length;
		
		if(hashVal < 0) {
			hashVal = hashVal + theLists.length;
		}
		
		return hashVal;
	}
    
    
    /**
     * 在哈希表中查找相关key
     * @param key
     * @return
     */
    public boolean contatin(AnyType key) {
    	
    	// 哈希表中存放相关key的链表
    	LinkedList list = theLists[hash3(key)];
		
    	//再调用链表的方法判断是否在此链表中
    	return list.contains(key);
    	
	}
   
    /**
     * 哈希表扩容
     */
    public void refesh() {
    	//扩容
    }
	
    
    public boolean insert(AnyType key) {
    	
    	// 哈希表中存放相关key的链表
    	LinkedList list = theLists[hash3(key)];
    	
    	if(!list.contains(key)) {
    		
    		list.add(key);
    		
    		// 判断是否需要扩容
    		if(++currentSize > theLists.length) {
    		refesh();
    		}
    		return true;
    	}
    	return false;
	}
    
    public boolean remove(AnyType key) {
    	// 哈希表中存放相关key的链表
    	LinkedList list = theLists[hash3(key)];
    	
    	if(list.contains(key)) {
    		
    		list.remove(key);
    		
    		currentSize--;
    		
    		return true;
    	}
    	return false;
    }
    
    
}