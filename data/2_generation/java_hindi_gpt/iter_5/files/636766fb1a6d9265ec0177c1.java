public class CharUtils {
    /** 
     * <p>जांचता है कि क्या वर्ण ASCII 7 बिट वर्णमाला के बड़े अक्षर हैं।</p> 
     * <pre> 
     * CharUtils.isAsciiAlphaUpper('a')  = false 
     * CharUtils.isAsciiAlphaUpper('A')  = true 
     * CharUtils.isAsciiAlphaUpper('3')  = false 
     * CharUtils.isAsciiAlphaUpper('-')  = false 
     * CharUtils.isAsciiAlphaUpper('\n') = false 
     * CharUtils.isAsciiAlphaUpper('&copy;') = false 
     * </pre>
     * @param ch  जांचने के लिए वर्ण
     * @return 65 और 90 के बीच (समावेशी) होने पर true
     */
    public static boolean isAsciiAlphaUpper(final char ch) {
        return ch >= 65 && ch <= 90;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiAlphaUpper('a'));  // false
        System.out.println(isAsciiAlphaUpper('A'));  // true
        System.out.println(isAsciiAlphaUpper('3'));  // false
        System.out.println(isAsciiAlphaUpper('-'));  // false
        System.out.println(isAsciiAlphaUpper('\n')); // false
        System.out.println(isAsciiAlphaUpper('©'));  // false
    }
}