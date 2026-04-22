public class CharUtils {

    /**
     * <p>检查字符是否为 ASCII 7 位控制字符。</p> <pre> CharUtils.isAsciiControl('a')  = false CharUtils.isAsciiControl('A')  = false CharUtils.isAsciiControl('3')  = false CharUtils.isAsciiControl('-')  = false CharUtils.isAsciiControl('\n') = true CharUtils.isAsciiControl('&copy;') = false </pre>
     * @param ch  要检查的字符
     * @return 如果小于 32 或等于 127，则返回真
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