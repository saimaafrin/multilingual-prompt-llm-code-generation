public class ParameterSeparatorChecker {

    /** 
     * 确定参数名称是否在当前位置结束，即给定字符是否符合分隔符的条件。
     */
    private static boolean isParameterSeparator(final char c) {
        // Define the separator characters
        return c == ',' || c == ';' || Character.isWhitespace(c);
    }

    public static void main(String[] args) {
        // Test the isParameterSeparator method
        char testChar1 = ',';
        char testChar2 = ';';
        char testChar3 = ' ';
        char testChar4 = 'a';

        System.out.println(isParameterSeparator(testChar1)); // true
        System.out.println(isParameterSeparator(testChar2)); // true
        System.out.println(isParameterSeparator(testChar3)); // true
        System.out.println(isParameterSeparator(testChar4)); // false
    }
}