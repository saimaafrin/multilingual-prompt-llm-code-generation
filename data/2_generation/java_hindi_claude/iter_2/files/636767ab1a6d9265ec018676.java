public class HexDigitChecker {
    /**
     * Is this a hex digit?
     * @param c Character to check
     * @return true if c is a hex digit (0-9, a-f, A-F), false otherwise
     */
    public static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || 
               (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }
}