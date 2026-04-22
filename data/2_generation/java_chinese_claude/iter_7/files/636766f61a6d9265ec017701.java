package org.apache.commons.lang3;

public class StringUtils {
    /**
     * 查找字符串中的最后一个索引，能够处理 <code>null</code>。此方法使用 {@link String#lastIndexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为null
     * @param searchStr 要查找的字符串，可以为null
     * @return 如果str或searchStr为null则返回-1，否则返回searchStr在str中最后出现的位置，如果未找到则返回-1
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
}