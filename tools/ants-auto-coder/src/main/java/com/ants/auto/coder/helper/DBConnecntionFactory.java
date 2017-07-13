package com.ants.auto.coder.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ants.auto.coder.common.DatabaseConfig;

/**
* @Description: 数据库连接工厂
* @author smatiger
* @date 2017年5月3日 下午5:35:19 
*/
public class DBConnecntionFactory {

    private Logger                      logger = LoggerFactory
                                                   .getLogger(DBConnecntionFactory.class);

    private static DBConnecntionFactory dbconnecntionFactory;
    private DatabaseConfig              databaseConfig;

    public static DBConnecntionFactory build(DatabaseConfig databaseConfig) {
        if (dbconnecntionFactory == null) {
            newInstance(databaseConfig);
        }
        return dbconnecntionFactory;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseConfig.getUrl(),
                databaseConfig.getUserName(), databaseConfig.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void close(ResultSet resultSet) {
        close(resultSet, null, null);
    }

    public void close(Statement statement) {
        close(null, statement, null);
    }

    public void close(Connection connection) {
        close(null, null, connection);
    }

    public void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("", e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("", e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("", e);
            }
        }
    }

    private DBConnecntionFactory(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        if (databaseConfig == null || StringUtils.isBlank(databaseConfig.getDriver())) {
            throw new IllegalArgumentException("数据库配置对象不能为空！");
        }
        try {
            Class.forName(databaseConfig.getDriver());
        } catch (ClassNotFoundException e) {
            logger.error("class {} is not found!", databaseConfig.getDriver(), e);
        }
    }

    private synchronized static void newInstance(DatabaseConfig databaseConfig) {
        if (dbconnecntionFactory == null) {
            dbconnecntionFactory = new DBConnecntionFactory(databaseConfig);
        }
    }

}
