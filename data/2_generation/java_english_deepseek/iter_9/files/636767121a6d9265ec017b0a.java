private int parseEndOfLine(String headerPart, int end) {
    // Iterate through the headerPart starting from the given end index
    for (int i = end; i < headerPart.length(); i++) {
        // Check if the current character is '\r' and the next is '\n'
        if (headerPart.charAt(i) == '\r' && i + 1 < headerPart.length() && headerPart.charAt(i + 1) == '\n') {
            return i; // Return the index of '\r'
        }
    }
    return -1; // Return -1 if no end of line sequence is found
}