private int parseEndOfLine(String headerPart, int end) {
    int index = headerPart.indexOf("\r\n", end);
    if (index == -1) {
        index = headerPart.indexOf("\n", end);
    }
    return index;
}