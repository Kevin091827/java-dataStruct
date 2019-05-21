package com.graph.demo;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description:    图类
 * @Author:         Kevin
 * @CreateDate:     2019/5/22 1:14
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/5/22 1:14
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class Graph {

    //顶点数组
    private Vertex[] vertexList;
    //邻接矩阵
    private int[][] adjMat;
    //顶点最大数目
    private int maxSize;
    //当前顶点
    private int nVertex;

    public Graph(){
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        //初始化邻接表
        for(int i = 0;i < maxSize;i++){
            for (int j = 0;j < maxSize;j++){
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
    }

    /**
     * 添加顶点
     * @param label
     */
    public void addVertex(String label){
        vertexList[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     * @param start
     * @param end
     */
    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
    }

    /**
     * 获取未访问过的顶点
     * @param i
     * @return
     */
    public int getUnvisitedVertex(int i){
        for(int j = 0;j < nVertex;j++){
            if(adjMat[i][j] == 1 && vertexList[i].isVisited == false){
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     */
    public void dfs(){
        Stack<Integer> stack = new Stack<>();
        //访问第一个顶点，修改状态
        vertexList[0].isVisited = true;
        //获取第一个顶点名
        System.out.println(vertexList[0].getLabel());
        //入栈
        stack.push(0);
        while(!stack.isEmpty()){
            //获取该顶点邻接的未被访问的顶点
            int v = getUnvisitedVertex(stack.peek());
            if(v == -1){
                //都访问过则回退
                stack.pop();
            }else {
                //未访问过则修改访问状态，再压进栈重复该过程
                vertexList[v].isVisited = true;
                System.out.println(vertexList[v].getLabel());
                stack.push(v);
            }
        }
        // 重置，防止后边再次使用dfs
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].isVisited = false;
        }

    }

    /**
     * 广度优先遍历
     */
    public void bfs(){

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        //访问第一个顶点，修改状态
        vertexList[0].isVisited = true;
        //获取第一个顶点名
        System.out.println(vertexList[0].getLabel());
        //入队
        queue.add(0);
        int i;
        //从队列中删除队头顶点，将与其相邻的未被访问的顶点插入队列中；
        while(!queue.isEmpty()){
            int v = queue.remove();
            while ((i = getUnvisitedVertex(v)) != -1){
                vertexList[i].isVisited = true;
                System.out.println(vertexList[i].getLabel());
                queue.add(i);
            }
        }
        // 重置，防止后边再次使用dfs
        for (int j = 0; j < nVertex; j++) {
            vertexList[j].isVisited = false;
        }
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public void setVertexList(Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }

    public void setAdjMat(int[][] adjMat) {
        this.adjMat = adjMat;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getnVertex() {
        return nVertex;
    }

    public void setnVertex(int nVertex) {
        this.nVertex = nVertex;
    }
}
