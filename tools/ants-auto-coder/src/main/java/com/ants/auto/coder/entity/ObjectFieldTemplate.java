package com.ants.auto.coder.entity;

/**
* @Description: 对象字段
* @author smatiger
* @date 2017年7月12日 下午5:46:11 
*/
public class ObjectFieldTemplate {

    private String comment;
    private String type;
    private String name;
    private String firstCamelName;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstCamelName() {
        return firstCamelName;
    }

    public void setFirstCamelName(String firstCamelName) {
        this.firstCamelName = firstCamelName;
    }

}
