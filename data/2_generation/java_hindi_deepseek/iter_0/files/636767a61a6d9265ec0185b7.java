/**
 * किसी अक्षर को अंक के रूप में व्याख्या करें (किसी भी आधार में 36 तक) और संख्यात्मक मान लौटाएं। यह {@code Character.digit()} के समान है लेकिन हम गैर-ASCII अंकों को स्वीकार नहीं करते हैं।
 */
private static int digitValue(final char c) {
    // ASCII range for digits '0'-'9' is 48-57
    if (c >= '0' && c <= '9') {
        return c - '0';
    }
    // ASCII range for uppercase letters 'A'-'Z' is 65-90
    if (c >= 'A' && c <= 'Z') {
        return 10 + (c - 'A');
    }
    // ASCII range for lowercase letters 'a'-'z' is 97-122
    if (c >= 'a' && c <= 'z') {
        return 10 + (c - 'a');
    }
    // If the character is not a valid digit or letter, return -1
    return -1;
}