public class DigitValueConverter {

    /**
     * किसी अक्षर को अंक के रूप में व्याख्या करें (किसी भी आधार में 36 तक) और संख्यात्मक मान लौटाएं। यह {@code Character.digit()} के समान है लेकिन हम गैर-ASCII अंकों को स्वीकार नहीं करते हैं।
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // ASCII '0' to '9'
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // ASCII 'A' to 'Z'
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // ASCII 'a' to 'z'
        } else {
            return -1; // Invalid character
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(digitValue('0')); // Output: 0
        System.out.println(digitValue('9')); // Output: 9
        System.out.println(digitValue('A')); // Output: 10
        System.out.println(digitValue('Z')); // Output: 35
        System.out.println(digitValue('a')); // Output: 10
        System.out.println(digitValue('z')); // Output: 35
        System.out.println(digitValue('@')); // Output: -1 (Invalid character)
    }
}