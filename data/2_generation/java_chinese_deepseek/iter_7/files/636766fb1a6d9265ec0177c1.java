/**
 * 检查字符是否为 ASCII 7 位字母大写字母。
 * <pre>
 * CharUtils.isAsciiAlphaUpper('a')  = false
 * CharUtils.isAsciiAlphaUpper('A')  = true
 * CharUtils.isAsciiAlphaUpper('3')  = false
 * CharUtils.isAsciiAlphaUpper('-')  = false
 * CharUtils.isAsciiAlphaUpper('\n') = false
 * CharUtils.isAsciiAlphaUpper('&copy;') = false
 * </pre>
 * @param ch  要检查的字符
 * @return 如果在 65 到 90 之间（包括 65 和 90），则返回真
 */
public static boolean isAsciiAlphaUpper(final char ch) {
    return ch >= 'A' && ch <= 'Z';
}