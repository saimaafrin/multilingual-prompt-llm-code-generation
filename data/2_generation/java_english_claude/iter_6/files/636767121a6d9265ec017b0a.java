import java.lang.String;

public class HeaderParser {

    /**
     * Skips bytes until the end of the current line.
     * @param headerPart The headers, which are being parsed.
     * @param end Index of the last byte, which has yet been processed.
     * @return Index of the \r\n sequence, which indicates end of line.
     */
    private int parseEndOfLine(String headerPart, int end) {
        int index = end;
        
        // Search for \r\n sequence
        while (index < headerPart.length()) {
            // Found \r\n sequence
            if (index + 1 < headerPart.length() && 
                headerPart.charAt(index) == '\r' && 
                headerPart.charAt(index + 1) == '\n') {
                return index;
            }
            index++;
        }
        
        // No end of line found, return original end position
        return end;
    }
}