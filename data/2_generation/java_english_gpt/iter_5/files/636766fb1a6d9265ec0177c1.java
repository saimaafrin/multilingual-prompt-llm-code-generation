public class CharUtils {
    
    /** 
     * <p>Checks whether the character is ASCII 7 bit alphabetic upper case.</p> 
     * <pre> 
     * CharUtils.isAsciiAlphaUpper('a')  = false 
     * CharUtils.isAsciiAlphaUpper('A')  = true 
     * CharUtils.isAsciiAlphaUpper('3')  = false 
     * CharUtils.isAsciiAlphaUpper('-')  = false 
     * CharUtils.isAsciiAlphaUpper('\n') = false 
     * CharUtils.isAsciiAlphaUpper('&copy;') = false 
     * </pre>
     * @param ch  the character to check
     * @return true if between 65 and 90 inclusive
     */
    public static boolean isAsciiAlphaUpper(final char ch) {
        return ch >= 65 && ch <= 90;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiAlphaUpper('a')); // false
        System.out.println(isAsciiAlphaUpper('A')); // true
        System.out.println(isAsciiAlphaUpper('3')); // false
        System.out.println(isAsciiAlphaUpper('-')); // false
        System.out.println(isAsciiAlphaUpper('\n')); // false
        System.out.println(isAsciiAlphaUpper('&')); // false
    }
}