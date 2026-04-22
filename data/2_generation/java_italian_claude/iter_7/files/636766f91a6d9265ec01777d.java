public class HexConverter {
    /**
     * @param b Un carattere codificato in ASCII da 0-9, a-f, A-F
     * @return Il valore byte del carattere da 0 a 16.
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