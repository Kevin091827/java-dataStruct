package com.list.demo;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * @Description:    DOTO
 * @Author:         Kevin
 * @CreateDate:     2019/4/20 2:12
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/4/20 2:12
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class MyArrayList implements List{

    //默认大小
    private int DEFAULT_SIZE = 10;

    //arrayList
    private int[] array;

    private int size = size();

    /**
     * 无参默认构造
     */
    public MyArrayList(){
        array = new int[DEFAULT_SIZE];
    }

    /**
     * 有参指定构造
     * @param size
     */
    public MyArrayList(int size){
        array = new int[size];
    }

    /**
     * arrayList大小
     * @return
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     * 获取指定下标的元素
     * @param i
     * @return
     */
    @Override
    public Object get(int i) {
        return array[i];
    }

    /**
     * 判断arraylist是否为空list
     * @return
     */
    @Override
    public boolean isEmpty() {

        if(size() != 0){
            return true;
        }
        return false;
    }

    /**
     * 判断是否包含指定元素
     * @param e
     * @return
     */
    @Override
    public boolean contain(int e) {
        for(int i = 0;i<array.length;i++){
            if(e == array[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定元素的下标
     * @param e
     * @return
     */
    @Override
    public int indexOf(int e) {
        rangeCheckForAdd(e);
        for(int i = 0;i<array.length;i++){
            if(array[i] == e){
                return i;
            }
        }
        throw new RuntimeException();
    }

    /**
     * 在指定位置添加指定元素
     * @param e
     * @param index
     */
    @Override
    public void add(int e, int index) {
        rangeCheckForAdd(index);
        int[] newArrayList = new int[size()+1];
        for(int i = 0;i < array.length;i++){
            newArrayList[i] = array[i];
        }
        for(int i = newArrayList.length - 1;i<index;i--){
            newArrayList[i] = newArrayList[i-1];
        }
        newArrayList[index] = e;
    }

    /**
     * 在表尾端添加指定元素
     * @param e
     */
    @Override
    public void addEnd(int e) {
       array[size++] = e;
    }

    /**
     * 在指定元素e前加入a
     * @param e
     * @param a
     */
    @Override
    public void addBefore(int e, int a) {
        if(contain(e) == true){
            int i = indexOf(e);
            add(a,i);
        }else {
            System.out.println("没有该元素!");
        }
    }

    /**
     * 仔e之后加a元素
     * @param e
     * @param a
     */
    @Override
    public void addAfter(int e, int a) {
        if(contain(e) == true){
            int i = indexOf(e);

        }else {
            System.out.println("没有该元素!");
        }
    }

    @Override
    public int replace(int i, int e) {
        return 0;
    }


    @Override
    public boolean remove(int e) {
        return false;
    }

    /**
     * 判断数组是否越界
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size()){
            throw new IndexOutOfBoundsException();
        }
    }

}
