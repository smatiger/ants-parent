package com.ants.auto.coder.common;

/**
* @Description: 自动配置常量类
* @author smatiger
* @date 2017年5月3日 下午5:18:48 
*/
public class AutoConfigConstants {

    /** 代码生成器配置路径 */
    public static final String CODER_CONFIG_PATH      = "yaml/coder-config.yaml";
    /** sql mapper 模版文件名称 */
    public static final String FTL_MAPPER_FILE_NAME   = "auto-mapper.ftl";
    /** dao 模版文件名称 */
    public static final String FTL_DAO_FILE_NAME      = "auto-dao.ftl";

    /** 数据库配置策略，库存重新生成 */
    public final static String DATA_BASE_POLICY_ALL   = "all";
    /** 数据库配置策略，单表重新生成（默认） */
    public final static String DATA_BASE_POLICY_ASIGN = "asign";

}
