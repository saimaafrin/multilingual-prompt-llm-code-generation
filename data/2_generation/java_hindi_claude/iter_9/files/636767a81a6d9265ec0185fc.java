import java.io.IOException;
import java.io.InputStream;

public class ProtocolParser {
    private final InputStream input;
    private int position = 0;
    
    public ProtocolParser(InputStream input) {
        this.input = input;
    }

    /**
     * Attempt to read a field tag, returning zero if we have reached EOF. 
     * Protocol message parsers use this to read tags, since a protocol message 
     * may legally end wherever a tag occurs, and zero is not a valid tag number.
     *
     * @return The tag number read, or 0 if EOF is reached
     * @throws IOException If there is an error reading from the input stream
     */
    public int readTag() throws IOException {
        // Check if we've reached EOF
        int firstByte = input.read();
        if (firstByte == -1) {
            return 0;
        }
        
        position++;
        
        // For simple tags that fit in 1 byte
        if ((firstByte & 0x80) == 0) {
            return firstByte;
        }
        
        // For multi-byte tags
        int result = firstByte & 0x7f;
        int shift = 7;
        
        while (true) {
            int nextByte = input.read();
            if (nextByte == -1) {
                throw new IOException("Truncated message");
            }
            
            position++;
            result |= (nextByte & 0x7f) << shift;
            
            if ((nextByte & 0x80) == 0) {
                return result;
            }
            
            shift += 7;
            if (shift >= 32) {
                throw new IOException("Tag is too large");
            }
        }
    }
}