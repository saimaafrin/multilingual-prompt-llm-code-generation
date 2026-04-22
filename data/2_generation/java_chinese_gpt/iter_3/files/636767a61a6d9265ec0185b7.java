public class CharacterDigitValue {

    /**
     * 将字符解释为数字（在任何基数下最多为36），并返回其数值。这类似于 {@code Character.digit()}，但我们不接受非ASCII数字。
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
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
        // Uncommenting the following line will throw an exception
        // System.out.println(digitValue('@')); // Invalid character
    }
}