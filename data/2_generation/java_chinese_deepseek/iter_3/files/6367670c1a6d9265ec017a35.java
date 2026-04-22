/**
 * 检查一个字符串是否以指定的后缀结尾（可选是否区分大小写）。
 * @see String#endsWith(String)
 * @param str  要检查的字符串，可以为空
 * @param suffix 要查找的后缀，可以为空
 * @param ignoreCase 指定比较是否应忽略大小写（不区分大小写）。
 * @return 如果字符串以后缀结尾或两个都是 <code>null</code>则返回<code>true</code>
 */
private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
    if (str == null && suffix == null) {
        return true;
    }
    if (str == null || suffix == null) {
        return false;
    }
    if (ignoreCase) {
        return str.toLowerCase().endsWith(suffix.toLowerCase());
    } else {
        return str.endsWith(suffix);
    }
}