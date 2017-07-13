package com.ants.auto.coder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.ants.auto.coder.common.AutoConfigConstants;
import com.ants.auto.coder.common.CoderConfig;
import com.ants.auto.coder.entity.AutoCoderObject;
import com.ants.auto.coder.entity.DataObjectTemplate;
import com.ants.auto.coder.entity.Table;
import com.ants.auto.coder.helper.CoderConfigHelper;
import com.ants.auto.coder.helper.DBHelper;
import com.ants.auto.coder.helper.FreeMarkerHelper;
import com.google.common.collect.Lists;

/**
* @Description: 运行开始类
* @author smatiger
* @date 2017年5月3日 下午5:22:10 
*/
public class RunStart {

    private static Logger logger = LoggerFactory.getLogger(RunStart.class);

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        // 读取配置文件
        CoderConfig coderConfig = CoderConfigHelper
            .readConfig(AutoConfigConstants.CODER_CONFIG_PATH);
        System.out.println(JSON.toJSONString(coderConfig));
        // 根据配置文件，预处理数据库对象
        AutoCoderObject autoCoderObject = preparedDataObjectList(coderConfig);
        // 生成代码
        writeCoder(coderConfig, autoCoderObject);
    }

    private static void writeCoder(CoderConfig coderConfig, AutoCoderObject autoCoderObject)
                                                                                            throws IOException {
        if (autoCoderObject == null) {
            logger.info("autoCoderObject is null!");
            return;
        }
        for (DataObjectTemplate dataObjectTemplate : autoCoderObject.getDataObjectList()) {
            Map<String, Object> root = new HashMap<String, Object>();
            root.put("dataObject", dataObjectTemplate);
            String daoContent = FreeMarkerHelper
                .getText(AutoConfigConstants.FTL_DO_FILE_NAME, root);
            FileUtils.writeStringToFile(new File("D:/aa.java"), daoContent,
                Charset.forName("UTF-8"));
        }
    }

    private static AutoCoderObject preparedDataObjectList(CoderConfig coderConfig) {
        List<Table> tables = DBHelper.getTables(coderConfig.getDatabaseConfig());
        List<DataObjectTemplate> dataObjectList = Lists.newArrayList();
        // table转换成DO
        DataObjectConverter.convert(tables, dataObjectList);
        AutoCoderObject autoCoderObject = new AutoCoderObject();
        autoCoderObject.setDataObjectList(dataObjectList);
        return autoCoderObject;
    }
}
