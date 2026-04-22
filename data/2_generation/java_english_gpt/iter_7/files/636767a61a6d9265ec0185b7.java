public class DigitValueInterpreter {

    /** 
     * Interpret a character as a digit (in any base up to 36) and return the numeric value. This is like {@code Character.digit()} but we don't accept non-ASCII digits.
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // ASCII '0' to '9'
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // ASCII 'A' to 'Z'
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // ASCII 'a' to 'z'
        } else {
            return -1; // Non-ASCII digit
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(digitValue('0')); // 0
        System.out.println(digitValue('9')); // 9
        System.out.println(digitValue('A')); // 10
        System.out.println(digitValue('Z')); // 35
        System.out.println(digitValue('a')); // 10
        System.out.println(digitValue('z')); // 35
        System.out.println(digitValue('@')); // -1
    }
}