package com.ants.auto.coder.helper;

import org.apache.commons.lang.StringUtils;
import org.yaml.snakeyaml.Yaml;

import com.ants.auto.coder.common.CoderConfig;

/**
* @Description: 代码生成器配置帮助类
* @author smatiger
* @date 2017年5月3日 下午5:43:15 
*/
public class CoderConfigHelper {

    /**
    * @Description: 读取配置
    * @author smatiger
    * @param coderConfigPath
    * @return
    * @throws
    */
    public static CoderConfig readConfig(String coderConfigPath) {
        String yamlPath = FileHelper.getClassPath() + coderConfigPath;
        String yamlString = FileHelper.readFileToString(yamlPath);
        if (StringUtils.isBlank(yamlString)) {
            throw new RuntimeException("yaml file [" + yamlPath + "] content is empty!");
        }
        CoderConfig coderConfig = new Yaml().loadAs(yamlString, CoderConfig.class);
        return coderConfig;
    }

}
