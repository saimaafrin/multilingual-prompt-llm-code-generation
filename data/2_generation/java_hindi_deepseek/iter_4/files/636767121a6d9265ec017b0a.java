private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r') {
            if (index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
                return index;
            }
        } else if (currentChar == '\n') {
            return index;
        }
        index++;
    }
    return -1; // Return -1 if no end of line sequence is found
}