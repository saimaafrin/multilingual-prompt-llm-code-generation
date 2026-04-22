private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' || currentChar == '\n') {
            // Check if the next character is part of the line ending sequence
            if (index + 1 < headerPart.length()) {
                char nextChar = headerPart.charAt(index + 1);
                if ((currentChar == '\r' && nextChar == '\n') || (currentChar == '\n' && nextChar == '\r')) {
                    return index; // Return the index of the start of the line ending sequence
                }
            } else {
                return index; // Return the index if it's the last character
            }
        }
        index++;
    }
    return -1; // Return -1 if no line ending sequence is found
}