package com.ahuixst.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

/**
 * @Author: ahui
 * @Description: 获取资源文件
 * @DateTime: 2022/3/28 - 12:09
 **/
public class ResourceUtil {

    private static ResourceUtil RESOURCE_UTIL = null;
    private static ResourceBundle BUNDLE = ResourceBundle.getBundle("db");

    private ResourceUtil() {

    }

    /**
     * 工厂实现配置文件读取
     *
     * @param properties 参数
     * @return ResourceUtil 工具类
     */
    public static ResourceUtil getInstance(String properties) {
        if (RESOURCE_UTIL == null) {
            RESOURCE_UTIL = new ResourceUtil();
        }
        if (properties != null) {
            BUNDLE = java.util.ResourceBundle.getBundle(properties);
        }
        return RESOURCE_UTIL;
    }

    /**
     * 工厂实现配置文件读取
     *
     * @return ResourceUtil
     */
    public static ResourceUtil getInstance() {

        if (RESOURCE_UTIL == null) {
            RESOURCE_UTIL = new ResourceUtil();
        }
        return RESOURCE_UTIL;
    }

    /**
     * 主要功能:获取配置文件参数
     * 注意事项:无
     *
     * @param name 参数名称
     * @return 参数名称对应值
     */
    public static String getConfigByName(String name) {
        String value = "";
        try {
            value = new String(BUNDLE.getString(name).getBytes("iso8859-1"), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 主要功能:取得分隔符
     * 注意事项:无
     *
     * @return 分隔符
     */
    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

}
