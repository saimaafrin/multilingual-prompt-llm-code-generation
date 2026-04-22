private int parseEndOfLine(String headerPart, int end) {
    if (headerPart == null || end < 0 || end > headerPart.length()) {
        throw new IllegalArgumentException("Invalid input parameters");
    }

    int lineEnd = headerPart.indexOf("\r\n", end);
    if (lineEnd == -1) {
        lineEnd = headerPart.length();
    } else {
        lineEnd += 2; // Include the length of "\r\n"
    }

    return lineEnd;
}