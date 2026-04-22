public class HexConverter {
    /**
     * @param b 一个 ASCII 编码的字符，范围为 0-9、a-f、A-F
     * @return 字符的字节值，范围为 0-16。
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte)(b - '0');
        }
        if (b >= 'a' && b <= 'f') {
            return (byte)(b - 'a' + 10);
        }
        if (b >= 'A' && b <= 'F') {
            return (byte)(b - 'A' + 10);
        }
        throw new IllegalArgumentException("Invalid hex digit: " + (char)b);
    }
}