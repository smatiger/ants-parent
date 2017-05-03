package com.ants.auto.coder.entity;

/**
* @Description: 表列
* @author smatiger
* @date 2017年5月3日 下午4:44:07 
*/
public class TableColumn {
    /** 字段类型 */
    private int    type;
    /** 字段名称 */
    private String name;
    /** 字段注释 */
    private String comment;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
