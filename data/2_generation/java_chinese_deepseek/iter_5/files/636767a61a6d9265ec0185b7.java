/**
 * 将字符解释为数字（在任何基数下最多为36），并返回其数值。这类似于 {@code Character.digit()}，但我们不接受非ASCII数字。
 */
private static int digitValue(final char c) {
    if (c >= '0' && c <= '9') {
        return c - '0';
    } else if (c >= 'A' && c <= 'Z') {
        return 10 + (c - 'A');
    } else if (c >= 'a' && c <= 'z') {
        return 10 + (c - 'a');
    } else {
        return -1; // 非ASCII数字或无效字符
    }
}