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
        if (input.available() == 0) {
            return 0;
        }

        int tag = 0;
        int shift = 0;
        
        while (shift < 32) {
            int b = input.read();
            
            // Check for EOF
            if (b == -1) {
                return shift == 0 ? 0 : tag;
            }
            
            // Add the current byte to the tag
            tag |= (b & 0x7F) << shift;
            
            // If the high bit is not set, we're done reading the tag
            if ((b & 0x80) == 0) {
                position += shift/7 + 1;
                return tag;
            }
            
            shift += 7;
        }
        
        // Tag is too long - protocol error
        throw new IOException("Invalid tag: too many bytes");
    }
    
    /**
     * Gets the current position in the input stream
     * @return Current position
     */
    public int getPosition() {
        return position;
    }
}