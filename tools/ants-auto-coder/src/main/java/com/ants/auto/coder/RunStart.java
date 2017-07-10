package com.ants.auto.coder;

import com.alibaba.fastjson.JSON;
import com.ants.auto.coder.common.AutoConfigConstants;
import com.ants.auto.coder.common.CoderConfig;
import com.ants.auto.coder.helper.CoderConfigHelper;

/**
* @Description: 运行开始类
* @author smatiger
* @date 2017年5月3日 下午5:22:10 
*/
public class RunStart {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        // 读取配置文件
        CoderConfig coderConfig = CoderConfigHelper
            .readConfig(AutoConfigConstants.CODER_CONFIG_PATH);
        System.out.println(JSON.toJSONString(coderConfig));

    }
}
