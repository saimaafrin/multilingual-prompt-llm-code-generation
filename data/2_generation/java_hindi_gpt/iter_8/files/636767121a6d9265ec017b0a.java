private int parseEndOfLine(String headerPart, int end) {
    // Check if the end index is within the bounds of the headerPart string
    if (end < 0 || end >= headerPart.length()) {
        throw new IllegalArgumentException("End index is out of bounds");
    }

    // Find the end of the line by searching for the line terminators
    int lineEnd = headerPart.indexOf("\r\n", end);
    if (lineEnd == -1) {
        lineEnd = headerPart.indexOf('\n', end);
    }
    if (lineEnd == -1) {
        lineEnd = headerPart.length(); // If no line end found, return the length of the string
    }

    return lineEnd;
}