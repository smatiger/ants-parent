package com.ants.auto.coder.entity;

import java.util.List;

/**
* @Description: table对象
* @author smatiger
* @date 2017年5月3日 下午4:43:34 
*/
public class Table {
    /** 表名 */
    private String            name;
    /** 列集合 */
    private List<TableColumn> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
}
