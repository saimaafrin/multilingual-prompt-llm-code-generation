public class CharUtils {
    /**
     * <p>将字符转换为 Character 对象。</p> 
     * <p>对于 ASCII 7 位字符，此方法使用缓存，每次调用都会返回相同的 Character 对象。</p> 
     * <pre> CharUtils.toCharacterObject(' ')  = ' ' 
     * CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  要转换的字符
     * @return 指定字符的 Character 对象
     */
    public static Character toCharacterObject(final char ch) {
        if (ch >= 0 && ch <= 127) {
            return Character.valueOf(ch);
        }
        return new Character(ch);
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
    }
}