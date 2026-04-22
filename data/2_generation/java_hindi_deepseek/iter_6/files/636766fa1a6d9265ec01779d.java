public class CharUtils {

    /**
     * <p>जांच करता है कि क्या वर्ण ASCII 7 बिट नियंत्रण है।</p> <pre> CharUtils.isAsciiControl('a')  = false CharUtils.isAsciiControl('A')  = false CharUtils.isAsciiControl('3')  = false CharUtils.isAsciiControl('-')  = false CharUtils.isAsciiControl('\n') = true CharUtils.isAsciiControl('&copy;') = false </pre>
     * @param ch  जांचने के लिए वर्ण
     * @return यदि 32 से कम या 127 के बराबर है तो true
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiControl('a'));  // false
        System.out.println(isAsciiControl('A'));  // false
        System.out.println(isAsciiControl('3'));  // false
        System.out.println(isAsciiControl('-'));  // false
        System.out.println(isAsciiControl('\n')); // true
        System.out.println(isAsciiControl('©'));  // false
    }
}