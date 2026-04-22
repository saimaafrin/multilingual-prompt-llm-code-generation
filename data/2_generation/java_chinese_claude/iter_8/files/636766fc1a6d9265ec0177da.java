public class ParameterParser {
    /**
     * 确定参数名称是否在当前位置结束，即给定字符是否符合分隔符的条件。
     */
    private static boolean isParameterSeparator(final char c) {
        return c == '=' || Character.isWhitespace(c);
    }
}