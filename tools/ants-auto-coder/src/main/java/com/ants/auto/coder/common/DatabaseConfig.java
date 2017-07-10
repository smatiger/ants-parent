package com.ants.auto.coder.common;

/**
* @Description: 数据库配置
* @author smatiger
* @date 2017年5月5日 上午10:44:28 
*/
public class DatabaseConfig {
    private String         driver;
    private String         url;
    private String         userName;
    private String         password;

    /** 数据库配置策略（单表重新生成、全库表重新生成）  */
    private DatabasePolicy policy;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DatabasePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(DatabasePolicy policy) {
        this.policy = policy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
