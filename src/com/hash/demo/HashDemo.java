package com.hash.demo;

/**
 * @Description:    散列结构
 * @Author:         Kevin
 * @CreateDate:     2019/4/18 14:30
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/18 14:30
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class HashDemo {
	
	/**
	 * 一个简单的散列函数（第一种）
	 * @param key 关键字
	 * @param tableSize 哈希表大小
	 * @return 
	 * 
	 * 优点：实现简单，计算快
	 * 缺点：当表的大小很大，函数将不会很好的分配关键字
	 */
	public int hash1(String key,int tableSize) {
		
		int hashVal = 0;
		
		// 将每一个字符的ASCII 码加起来
		for(int i = 0;i<key.length();i++) {
			hashVal += key.charAt(i);
		}
		
		// 返回这个数和表大小的模
		return hashVal % tableSize;
	}
	
	/**
	 * @param key
	 * @param tableSize
	 * @return
	 * 
	 * 容易浪费空间，大部分没有散列到
	 */
	public int  hash2(String key,int tableSize) {
		
		return key.charAt(0)+27*key.charAt(1)+729*key.charAt(2);
	}
	
	
	/**
	 * 这是一个比较好的哈希函数，剩下的问题就是解决冲突
	 * @param key
	 * @param tableSize
	 * @return
	 */
	public int hash3(String key,int tableSize) {
		
		int hashVal = 0;
		for(int i=0;i<key.length();i++) {
			hashVal = 37 * hashVal + key.charAt(i);
		}
		
		hashVal = hashVal % tableSize;
		
		if(hashVal < 0) {
			hashVal = hashVal + tableSize;
		}
		
		return hashVal;
	}
	
	
	/********************************************/
	/**************     解决冲突         *************/
	/********************************************/
	
	
	public static void main(String[] args) {
		
		HashDemo hashDemo = new HashDemo();
		System.out.println(hashDemo.hash1("kevin", 20));
	}

}
