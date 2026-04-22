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
            return -1; // 非法字符
        }
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(digitValue('0')); // 输出: 0
        System.out.println(digitValue('9')); // 输出: 9
        System.out.println(digitValue('A')); // 输出: 10
        System.out.println(digitValue('Z')); // 输出: 35
        System.out.println(digitValue('a')); // 输出: 10
        System.out.println(digitValue('z')); // 输出: 35
        System.out.println(digitValue('@')); // 输出: -1
    }
}