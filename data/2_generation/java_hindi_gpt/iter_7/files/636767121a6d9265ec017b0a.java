private int parseEndOfLine(String headerPart, int end) {
    if (headerPart == null || end < 0 || end > headerPart.length()) {
        throw new IllegalArgumentException("Invalid headerPart or end index");
    }

    int lineEndIndex = headerPart.indexOf("\r\n", end);
    if (lineEndIndex == -1) {
        lineEndIndex = headerPart.length(); // If no CRLF found, return the length of the string
    }

    return lineEndIndex;
}