package com.ants.auto.coder.common;

import java.util.List;

/**
* @Description: 数据库配置策略
* @author smatiger
* @date 2017年5月5日 上午10:47:55 
*/
public class DatabasePolicy {

    /** 默认单表策略 */
    private String       type = AutoConfigConstants.DATA_BASE_POLICY_ASIGN;

    private List<String> tables;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }
}
