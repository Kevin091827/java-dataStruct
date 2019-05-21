package com.graph.demo;

/**
 * @Description:    顶点类
 * @Author:         Kevin
 * @CreateDate:     2019/5/22 0:37
 * @UpdateUser:     Kevin
 * @UpdateDate:     2019/5/22 0:37
 * @UpdateRemark:   修改内容
 * @Version: 1.0
 */
public class Vertex {

    //顶点名称
    private String label;

    //是否被访问过
    public boolean isVisited;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Vertex(String label){
        this.label = label;
    }
}
