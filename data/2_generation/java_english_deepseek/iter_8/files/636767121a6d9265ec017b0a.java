/**
 * Skips bytes until the end of the current line.
 * @param headerPart The headers, which are being parsed.
 * @param end Index of the last byte, which has yet been processed.
 * @return Index of the \r\n sequence, which indicates end of line.
 */
private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
            return index; // Return the index of the '\r' character
        }
        index++;
    }
    return -1; // Return -1 if no end of line is found
}