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
    return -1; // No se encontró el final de la línea
}