public class CharacterUtils {
    /**
     * Interpret a character as a digit (in any base up to 36) and return the numeric value. 
     * This is like {@code Character.digit()} but we don't accept non-ASCII digits.
     *
     * @param c The character to interpret as a digit
     * @param radix The radix (base) to use, must be between 2 and 36
     * @return The numeric value of the digit, or -1 if the character is not a valid digit in the given radix
     */
    public static int digitValue(char c, int radix) {
        if (radix < 2 || radix > 36) {
            return -1;
        }
        
        int value;
        if (c >= '0' && c <= '9') {
            value = c - '0';
        } else if (c >= 'a' && c <= 'z') {
            value = c - 'a' + 10;
        } else if (c >= 'A' && c <= 'Z') {
            value = c - 'A' + 10;
        } else {
            return -1;
        }
        
        return value < radix ? value : -1;
    }
}