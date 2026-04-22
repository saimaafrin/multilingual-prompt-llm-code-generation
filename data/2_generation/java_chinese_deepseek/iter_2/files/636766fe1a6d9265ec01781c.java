public class CharUtils {

    /**
     * <p>将字符转换为 Character 对象。</p> <p>对于 ASCII 7 位字符，此方法使用缓存，每次调用都会返回相同的 Character 对象。</p> <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  要转换的字符
     * @return 指定字符的 Character 对象
     */
    public static Character toCharacterObject(final char ch) {
        // 对于 ASCII 7 位字符（0-127），使用缓存
        if (ch <= 127) {
            return Character.valueOf(ch);
        }
        // 对于非 ASCII 字符，直接返回新的 Character 对象
        return new Character(ch);
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' '));  // 输出: ' '
        System.out.println(toCharacterObject('A'));  // 输出: 'A'
        System.out.println(toCharacterObject('€'));  // 输出: '€'
    }
}