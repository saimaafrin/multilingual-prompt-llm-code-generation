/**
 * किसी अक्षर को अंक के रूप में व्याख्या करें (किसी भी आधार में 36 तक) और संख्यात्मक मान लौटाएं। यह {@code Character.digit()} के समान है लेकिन हम गैर-ASCII अंकों को स्वीकार नहीं करते हैं।
 */
private static int digitValue(final char c) {
    // Check if the character is a digit (0-9)
    if (c >= '0' && c <= '9') {
        return c - '0';
    }
    // Check if the character is an uppercase letter (A-Z)
    if (c >= 'A' && c <= 'Z') {
        return 10 + (c - 'A');
    }
    // Check if the character is a lowercase letter (a-z)
    if (c >= 'a' && c <= 'z') {
        return 10 + (c - 'a');
    }
    // If the character is not a valid digit or letter, return -1
    return -1;
}