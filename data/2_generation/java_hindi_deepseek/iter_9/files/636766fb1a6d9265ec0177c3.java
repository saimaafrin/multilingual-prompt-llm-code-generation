public class CharUtils {

    /**
     * <p>जांचता है कि क्या वर्ण ASCII 7 बिट है।</p> 
     * <pre> 
     * CharUtils.isAscii('a')  = true 
     * CharUtils.isAscii('A')  = true 
     * CharUtils.isAscii('3')  = true 
     * CharUtils.isAscii('-')  = true 
     * CharUtils.isAscii('\n') = true 
     * CharUtils.isAscii('&copy;') = false 
     * </pre>
     * @param ch  जांचने के लिए वर्ण
     * @return यदि 128 से कम है तो true
     */
    public static boolean isAscii(final char ch) {
        return ch < 128;
    }

    public static void main(String[] args) {
        System.out.println(isAscii('a'));   // true
        System.out.println(isAscii('A'));   // true
        System.out.println(isAscii('3'));   // true
        System.out.println(isAscii('-'));  // true
        System.out.println(isAscii('\n')); // true
        System.out.println(isAscii('©'));   // false
    }
}