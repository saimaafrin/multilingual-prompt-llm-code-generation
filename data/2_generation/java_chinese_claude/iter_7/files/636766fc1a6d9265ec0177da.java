public class ParameterParser {
    /**
     * 确定参数名称是否在当前位置结束，即给定字符是否符合分隔符的条件。
     */
    private static boolean isParameterSeparator(final char c) {
        // Check if character is whitespace
        if (Character.isWhitespace(c)) {
            return true;
        }
        
        // Check for common parameter separators
        switch (c) {
            case '(':
            case ')':
            case '<':
            case '>':
            case '@':
            case ',':
            case ';':
            case ':':
            case '\\':
            case '"':
            case '/':
            case '[':
            case ']':
            case '?':
            case '=':
            case '{':
            case '}':
                return true;
            default:
                return false;
        }
    }
}