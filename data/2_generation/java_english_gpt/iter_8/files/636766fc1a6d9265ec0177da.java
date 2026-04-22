public class ParameterSeparatorChecker {

    /** 
     * Determine whether a parameter name ends at the current position, that is, whether the given character qualifies as a separator. 
     */
    private static boolean isParameterSeparator(final char c) {
        // Define the characters that are considered as separators
        return c == ',' || c == ';' || c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == ')' || c == ']';
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isParameterSeparator(',')); // true
        System.out.println(isParameterSeparator(';')); // true
        System.out.println(isParameterSeparator(' ')); // true
        System.out.println(isParameterSeparator('a')); // false
        System.out.println(isParameterSeparator(')')); // true
    }
}