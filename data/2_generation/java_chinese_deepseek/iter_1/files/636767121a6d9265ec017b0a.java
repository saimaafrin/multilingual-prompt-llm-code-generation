private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
            return index;
        }
        index++;
    }
    return -1; // 如果没有找到行结束符，返回-1
}