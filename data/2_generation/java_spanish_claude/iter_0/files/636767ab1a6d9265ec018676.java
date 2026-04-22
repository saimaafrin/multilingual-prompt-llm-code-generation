public class HexadecimalChecker {
    /**
     * ¿Es este un dígito hexadecimal?
     */
    private static boolean esHex(final char c) {
        return (c >= '0' && c <= '9') || 
               (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }
}