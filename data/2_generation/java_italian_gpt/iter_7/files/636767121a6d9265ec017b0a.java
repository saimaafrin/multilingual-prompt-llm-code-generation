private int parseEndOfLine(String headerPart, int end) {
    // Check if the end index is within the bounds of the string
    if (end < 0 || end >= headerPart.length()) {
        return -1; // Return -1 if the end index is out of bounds
    }

    // Iterate through the string starting from the end index
    for (int i = end; i < headerPart.length(); i++) {
        // Check for the end of line sequence "\r\n"
        if (i < headerPart.length() - 1 && headerPart.charAt(i) == '\r' && headerPart.charAt(i + 1) == '\n') {
            return i; // Return the index of the '\r' character
        }
    }

    // If the end of line sequence is not found, return -1
    return -1;
}