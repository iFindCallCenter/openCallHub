package com.och.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author danmo
 * @date 2024-02-20 18:41:33
 */
public class SQLFilterUtils {

    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        } else {
            str = StringUtils.replace(str, "'", "");
            str = StringUtils.replace(str, "\"", "");
            str = StringUtils.replace(str, ";", "");
            str = StringUtils.replace(str, "\\", "");
            str = str.toLowerCase();
            String[] keywords = new String[]{"master", "truncate", "insert", "select", "delete", "declare", "alert", "drop"};
            int length = keywords.length;

            for (int i = 0; i < length; ++i) {
                String keyword = keywords[i];
                if (str.contains(keyword)) {
                    throw new RuntimeException("包含非法字符");
                }
            }
            return str;
        }
    }
}
