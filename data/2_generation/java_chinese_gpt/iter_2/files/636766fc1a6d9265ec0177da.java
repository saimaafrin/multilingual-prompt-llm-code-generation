public class ParameterSeparatorChecker {

    /** 
     * 确定参数名称是否在当前位置结束，即给定字符是否符合分隔符的条件。
     */
    private static boolean isParameterSeparator(final char c) {
        // Define the separator characters
        return c == ',' || c == ';' || c == ' ' || c == '\n' || c == '\t';
    }

    public static void main(String[] args) {
        // Test the isParameterSeparator method
        char testChar1 = ',';
        char testChar2 = 'a';
        char testChar3 = ';';
        
        System.out.println(isParameterSeparator(testChar1)); // true
        System.out.println(isParameterSeparator(testChar2)); // false
        System.out.println(isParameterSeparator(testChar3)); // true
    }
}