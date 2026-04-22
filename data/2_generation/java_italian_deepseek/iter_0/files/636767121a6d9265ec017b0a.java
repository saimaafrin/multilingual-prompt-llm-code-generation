private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' || currentChar == '\n') {
            // Check if the next character is part of the line ending sequence
            if (currentChar == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
                return index + 2; // Return the index after \r\n
            } else {
                return index + 1; // Return the index after \r or \n
            }
        }
        index++;
    }
    return index; // Return the end of the string if no line ending is found
}