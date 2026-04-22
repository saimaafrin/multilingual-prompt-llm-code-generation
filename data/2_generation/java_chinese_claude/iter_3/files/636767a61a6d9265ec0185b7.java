public class CharacterUtils {
    /**
     * 将字符解释为数字（在任何基数下最多为36），并返回其数值。这类似于 {@code Character.digit()}，但我们不接受非ASCII数字。
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