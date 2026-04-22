/**
 * 确定参数名称是否在当前位置结束，即给定字符是否符合分隔符的条件。
 * 
 * @param c 要检查的字符
 * @return 如果字符是分隔符，则返回true；否则返回false
 */
private static boolean isParameterSeparator(final char c) {
    // 常见的分隔符包括空格、逗号、分号、括号等
    return c == ' ' || c == ',' || c == ';' || c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']';
}