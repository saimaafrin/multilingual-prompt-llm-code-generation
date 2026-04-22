/**
 * <p>检查字符是否为 ASCII 7 位。</p> <pre> CharUtils.isAscii('a')  = true CharUtils.isAscii('A')  = true CharUtils.isAscii('3')  = true CharUtils.isAscii('-')  = true CharUtils.isAscii('\n') = true CharUtils.isAscii('&copy;') = false </pre>
 * @param ch  要检查的字符
 * @return 如果小于 128 则返回真
 */
public static boolean isAscii(final char ch) {
    return ch < 128;
}