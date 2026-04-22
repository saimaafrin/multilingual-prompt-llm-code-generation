public class CharUtils {

    /**
     * <p>将字符转换为 Character 对象。</p> <p>对于 ASCII 7 位字符，此方法使用缓存，每次调用都会返回相同的 Character 对象。</p> <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  要转换的字符
     * @return 指定字符的 Character 对象
     */
    public static Character toCharacterObject(final char ch) {
        // ASCII 7-bit characters are in the range 0-127
        if (ch <= 127) {
            // Use the cached Character objects for ASCII characters
            return Character.valueOf(ch);
        } else {
            // For non-ASCII characters, create a new Character object
            return new Character(ch);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(CharUtils.toCharacterObject(' ') == ' ');  // true
        System.out.println(CharUtils.toCharacterObject('A') == 'A');  // true
        System.out.println(CharUtils.toCharacterObject('€') == '€');  // true (non-ASCII character)
    }
}