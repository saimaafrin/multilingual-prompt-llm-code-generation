public class CharacterUtils {
    /**
     * Interpret a character as a digit (in any base up to 36) and return the numeric value. 
     * This is like {@code Character.digit()} but we don't accept non-ASCII digits.
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return -1;
    }
}