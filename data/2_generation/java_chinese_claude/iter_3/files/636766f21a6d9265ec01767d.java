package com.utils;

/**
 * String utility class
 */
public class StringUtils {

    /**
     * 对象转字符串，当对象为空时返回空字符串，否则返回toString()
     * @param object 需要转换的对象
     * @return 转换后的字符串
     */
    public static String toString(Object object) {
        return object == null ? "" : object.toString();
    }
}