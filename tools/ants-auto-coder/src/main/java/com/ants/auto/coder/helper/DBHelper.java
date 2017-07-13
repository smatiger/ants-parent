package com.ants.auto.coder.helper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ants.auto.coder.common.AutoConfigConstants;
import com.ants.auto.coder.common.DatabaseConfig;
import com.ants.auto.coder.entity.Table;
import com.ants.auto.coder.entity.TableColumn;
import com.google.common.collect.Lists;

/**
* @Description: 数据库才做帮助类
* @author smatiger
* @date 2017年7月12日 下午4:18:10 
*/
public class DBHelper {
    private static Logger logger = LoggerFactory.getLogger(DBHelper.class);

    public static List<Table> getTables(DatabaseConfig databaseConfig) {
        Connection connection = DBConnecntionFactory.build(databaseConfig).getConnection();
        List<Table> tableList = null;
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            String[] types = { "TABLE" };
            ResultSet resultSet = metaData.getTables(null, null, "%", types);
            tableList = Lists.newArrayList();
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                if (AutoConfigConstants.DATA_BASE_POLICY_ASIGN.equals(databaseConfig.getPolicy()
                    .getType())) {
                    if (!databaseConfig.getPolicy().getTables().contains(tableName)) {
                        continue;
                    }
                }
                Table table = new Table();
                table.setName(tableName);
                ResultSet columnResultSet = metaData.getColumns(null, null, tableName, null);
                List<TableColumn> columnList = Lists.newArrayList();
                while (columnResultSet.next()) {
                    TableColumn tableColumn = new TableColumn();
                    String columnName = columnResultSet.getString(4);
                    int columnType = columnResultSet.getInt(5);
                    String comment = columnResultSet.getString(12);
                    tableColumn.setName(columnName);
                    tableColumn.setType(columnType);
                    tableColumn.setComment(comment);
                    columnList.add(tableColumn);
                }
                tableList.add(table);
            }
        } catch (SQLException e) {
            logger.error("", e);
        }
        return tableList;
    }

}
