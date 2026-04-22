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
        // If no line end is found, return the length of the headerPart
        return headerPart.length();
    }

    // Return the index of the end of the line
    return lineEnd + 2; // +2 to include the length of "\r\n"
}