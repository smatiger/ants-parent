package com.ants.auto.coder.helper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

/**
* @Description: 文件帮助类
* @author smatiger
* @date 2017年5月5日 上午10:42:07 
*/
public class FileHelper {

    /**
    * @Description: 读取文件转成string字符
    * @author smatiger
    * @param path 文件绝对路径
    * @return 文本字符
    * @throws
    */
    public static String readFileToString(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("file [" + path + "] is not found!");
        }
        if (!file.isFile()) {
            throw new RuntimeException("path [" + path + "] is not file!");
        }
        try {
            String fileContent = FileUtils.readFileToString(file, Charset.defaultCharset());
            return fileContent;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * @Description: 获取classpath路径
    * @author smatiger
    * @return 路径
    * @throws
    */
    public static String getClassPath() {
        URL url = CoderConfigHelper.class.getResource("/");
        if (url == null) {
            throw new RuntimeException("find class path faild!");
        }
        return url.getPath();
    }
}
