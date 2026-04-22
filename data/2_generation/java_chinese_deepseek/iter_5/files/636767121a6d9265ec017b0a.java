private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' || currentChar == '\n') {
            // Check if the next character is part of the line ending sequence
            if (index + 1 < headerPart.length()) {
                char nextChar = headerPart.charAt(index + 1);
                if ((currentChar == '\r' && nextChar == '\n') || (currentChar == '\n' && nextChar == '\r')) {
                    return index + 1; // Return the index of the second character in the sequence
                }
            }
            return index; // Return the index of the single line ending character
        }
        index++;
    }
    return -1; // No line ending found
}