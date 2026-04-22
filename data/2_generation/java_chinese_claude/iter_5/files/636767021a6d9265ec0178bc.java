package org.apache.commons.lang3;

public class StringUtils {
    /**
     * 在字符串中查找第一个索引，能处理 <code>null</code>。此方法使用 {@link String#indexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为null
     * @param searchStr 要查找的字符串，可以为null
     * @return 第一次出现的索引位置，如果str或searchStr为null则返回-1
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }
}