private int parseEndOfLine(String headerPart, int end) {
    // Check if the end index is within the bounds of the headerPart string
    if (end < 0 || end >= headerPart.length()) {
        throw new IllegalArgumentException("End index is out of bounds.");
    }

    // Find the end of the line by searching for the line break characters
    int lineEndIndex = headerPart.indexOf("\r\n", end);
    
    // If no line break is found, return the length of the headerPart
    if (lineEndIndex == -1) {
        return headerPart.length();
    }
    
    // Return the index of the end of the line
    return lineEndIndex;
}