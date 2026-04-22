public class CharUtils {

    /**
     * <p>将 Character 转换为 char，并处理 <code>null</code> 的情况。</p>
     * <pre> CharUtils.toChar(null, 'X') = 'X' CharUtils.toChar(' ', 'X')  = ' ' CharUtils.toChar('A', 'X')  = 'A' </pre>
     * @param ch  要转换的字符
     * @param defaultValue  如果 Character 为空时使用的默认值
     * @return Character 的 char 值，如果为空则返回默认值
     */
    public static char toChar(final Character ch, final char defaultValue) {
        return ch != null ? ch : defaultValue;
    }

    public static void main(String[] args) {
        System.out.println(toChar(null, 'X'));  // 输出: X
        System.out.println(toChar(' ', 'X'));   // 输出:  
        System.out.println(toChar('A', 'X'));   // 输出: A
    }
}