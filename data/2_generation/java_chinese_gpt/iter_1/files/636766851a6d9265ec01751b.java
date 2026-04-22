public class HexDecoder {

    /** 
     * 辅助函数，用于从字符串中解码十六进制数字的一半。
     * @param c 要解码的十六进制数字的ASCII字符。必须在 {@code [0-9a-fA-F]} 范围内。
     * @return 由给定的ASCII字符表示的十六进制值，如果字符无效，则返回 {@link Character#MAX_VALUE}。
     */
    private static char decodeHexNibble(final char c) {
        if (c >= '0' && c <= '9') {
            return (char) (c - '0');
        } else if (c >= 'a' && c <= 'f') {
            return (char) (c - 'a' + 10);
        } else if (c >= 'A' && c <= 'F') {
            return (char) (c - 'A' + 10);
        } else {
            return Character.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        // Test the decodeHexNibble function
        System.out.println(decodeHexNibble('0')); // Output: 0
        System.out.println(decodeHexNibble('9')); // Output: 9
        System.out.println(decodeHexNibble('a')); // Output: 10
        System.out.println(decodeHexNibble('f')); // Output: 15
        System.out.println(decodeHexNibble('A')); // Output: 10
        System.out.println(decodeHexNibble('F')); // Output: 15
        System.out.println(decodeHexNibble('g')); // Output: 65535 (Character.MAX_VALUE)
    }
}