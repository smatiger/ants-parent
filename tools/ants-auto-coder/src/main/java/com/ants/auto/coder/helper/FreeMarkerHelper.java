package com.ants.auto.coder.helper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ants.auto.coder.common.AutoConfigConstants;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
* @Description: freeMarker模版
* @author smatiger
* @date 2017年7月12日 下午5:13:07 
*/
public class FreeMarkerHelper {
    private static Logger        logger        = LoggerFactory.getLogger(FreeMarkerHelper.class);

    private static Configuration configuration = null;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_0);
        String templateLoaderPath = FreeMarkerHelper.class.getClassLoader()
            .getResource(AutoConfigConstants.FTL_PACKAGE_NAME).getFile();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        try {
            configuration.setDirectoryForTemplateLoading(new File(templateLoaderPath));
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public static String getText(String templateFileName, Map<String, Object> root) {
        Template template = getTemplate(templateFileName);
        String content = getText(template, root);
        return content;
    }

    private static String getText(Template template, Map<String, Object> root) {
        if (template == null) {
            throw new NullPointerException("template null!");
        }
        StringWriter stringWriter = new StringWriter();
        try {
            template.process(root, stringWriter);
        } catch (Exception e) {
            logger.error("", e);
            throw new RuntimeException(e);
        } finally {
            try {
                stringWriter.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return stringWriter.toString();
    }

    private static Template getTemplate(String name) {
        try {
            return configuration.getTemplate(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
