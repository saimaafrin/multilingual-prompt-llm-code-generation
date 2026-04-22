package org.apache.commons.lang3;

public class StringUtils {
    /**
     * 查找字符串中的最后一个索引，能够处理 <code>null</code>。此方法使用 {@link String#lastIndexOf(String)}。
     *
     * @param str 要搜索的字符串，可以为null
     * @param searchStr 要查找的字符串，可以为null
     * @return 如果两个字符串都不为null且searchStr在str中存在，则返回最后一个匹配的索引位置；
     *         如果searchStr为空字符串则返回str的长度；
     *         如果任一参数为null或searchStr不在str中，则返回-1
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
}