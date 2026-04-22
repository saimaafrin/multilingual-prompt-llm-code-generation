public class HeaderParser {

    /** 
     * Skips bytes until the end of the current line.
     * @param headerPart The headers, which are being parsed.
     * @param end Index of the last byte, which has yet been processed.
     * @return Index of the \r\n sequence, which indicates end of line.
     */
    private int parseEndOfLine(String headerPart, int end) {
        int index = end;
        while (index < headerPart.length()) {
            char currentChar = headerPart.charAt(index);
            if (currentChar == '\r') {
                // Check for the next character to see if it's a newline
                if (index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
                    return index + 1; // Return the index of the newline character
                }
            }
            index++;
        }
        return headerPart.length(); // Return the length if no end of line is found
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String headers = "Header1: Value1\r\nHeader2: Value2\r\n";
        int endIndex = parser.parseEndOfLine(headers, 0);
        System.out.println("End of line index: " + endIndex);
    }
}