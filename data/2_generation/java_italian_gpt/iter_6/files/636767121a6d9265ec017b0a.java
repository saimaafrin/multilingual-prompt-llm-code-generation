private int parseEndOfLine(String headerPart, int end) {
    if (headerPart == null || end < 0 || end >= headerPart.length()) {
        throw new IllegalArgumentException("Invalid input parameters");
    }

    for (int i = end; i >= 0; i--) {
        if (headerPart.charAt(i) == '\n') {
            return i; // Return the index of '\n'
        }
        if (headerPart.charAt(i) == '\r') {
            if (i > 0 && headerPart.charAt(i - 1) == '\n') {
                return i - 1; // Return the index of '\r' if preceded by '\n'
            }
            return i; // Return the index of '\r'
        }
    }
    return -1; // Return -1 if no end of line is found
}