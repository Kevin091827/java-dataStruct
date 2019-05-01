## java数据结构和算法总结

#### 项目描述
```yaml
src:
     com.hash.demo ：散列
     
     com.heap.demo ：堆

     com.list.demo ：表

     com.sort.demo ：排序算法

     com.stack.demo ：栈

     com.tree.demo ： 树

```

已完善模块：
```yaml
src：
  com.sort.demo ：排序算法
  com.crypto.demo:加密算法（仅仅整理了常用的几种加密算法）
```

### java排序算法总结
排序，这是一个很古老但是又很经典的问题，世界上有很多中优秀排序算法的实现，在这里，我总结了其他比较常用的几种排序算法
#### 1.java排序算法一览
1. [冒泡排序和基数排序](https://blog.csdn.net/weixin_41922289/article/details/89379901)
2. [桶排序和计数排序](https://blog.csdn.net/weixin_41922289/article/details/89354587)
3. [归并排序和快速排序](https://blog.csdn.net/weixin_41922289/article/details/89334243)
4. [堆排序](https://blog.csdn.net/weixin_41922289/article/details/89285521)
5. [插入排序和希尔排序](https://blog.csdn.net/weixin_41922289/article/details/89151737)


#### 2.分类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190419122816369.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTkyMjI4OQ==,size_16,color_FFFFFF,t_70)

#### 3.比较

**1.时间复杂度比较**

|算法| 乱序时间复杂度|有序时间复杂度|
|--|--|--|
| 插入排序 |  O(N^2)|O(N)|
|希尔排序|O(N^2)|O(N)
|冒泡排序|O(N^2)|O(N)
|基数排序|O(N)|O(N)
|桶排序|O(N)|
|计数排序|O(N)
|归并排序|O(NlogN)|O(NlogN)
|快速排序|O(NlogN)|O(N^2)
|堆排序|O(NlogN)




**2.空间复杂度比较**

|算法| 空间复杂度|
|--|--|
| 插入排序 |  O(1)
|希尔排序|O(1)
|冒泡排序|O(1)
|基数排序|O(N)
|桶排序|O(N+M)   M是额外辅助空间（桶数量）
|计数排序|O(N)
|归并排序|O(N)
|快速排序|O(1)
|堆排序|O(1)



### java加密算法总结

#### 1.分类

* 可逆加密(可以加密也可以解密)
    
    * Base64加密(依赖于jdk，通过反射实现)
    
    * AES加密(对称加密)

* 不可逆加密(只可以加密，不可以解密)
    
    * md5加密(安全性较sha1低，速度快)
    
    * sha1加密(安全性较md5高，速度慢)

