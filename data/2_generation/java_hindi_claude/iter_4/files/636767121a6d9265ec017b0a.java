import java.nio.charset.StandardCharsets;

public class HeaderParser {
    /**
     * Skips bytes until the end of the current line.
     * @param headerPart The headers, which are being parsed.
     * @param end Index of the last byte, which has yet been processed.
     * @return Index of the \r\n sequence, which indicates end of line.
     */
    public int skipLine(byte[] headerPart, int end) {
        int pos = end;
        
        // Search for \r\n sequence
        while (pos < headerPart.length - 1) {
            if (headerPart[pos] == '\r' && headerPart[pos + 1] == '\n') {
                return pos;
            }
            pos++;
        }
        
        // If we reach the end without finding \r\n, return the length
        return headerPart.length;
    }
}