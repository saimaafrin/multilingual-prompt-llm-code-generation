public class HexDecoder {
    /**
     * 辅助函数，用于从字符串中解码十六进制数字的一半。
     * @param c 要解码的十六进制数字的ASCII字符。必须在 {@code [0-9a-fA-F]} 范围内。
     * @return 由给定的ASCII字符表示的十六进制值，如果字符无效，则返回 {@link Character#MAX_VALUE}。
     */
    private static char decodeHexNibble(final char c) {
        // 处理数字 0-9
        if (c >= '0' && c <= '9') {
            return (char)(c - '0');
        }
        
        // 处理小写字母 a-f
        if (c >= 'a' && c <= 'f') {
            return (char)(c - 'a' + 10);
        }
        
        // 处理大写字母 A-F
        if (c >= 'A' && c <= 'F') {
            return (char)(c - 'A' + 10);
        }
        
        // 如果字符不在有效范围内，返回Character.MAX_VALUE
        return Character.MAX_VALUE;
    }
}