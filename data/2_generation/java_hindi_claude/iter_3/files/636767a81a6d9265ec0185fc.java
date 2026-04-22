import java.io.IOException;
import java.io.InputStream;

public class ProtocolParser {
    private final InputStream input;
    private int position = 0;
    
    public ProtocolParser(InputStream input) {
        this.input = input;
    }

    /**
     * Attempt to read a field tag, returning zero if we have reached EOF. Protocol message parsers 
     * use this to read tags, since a protocol message may legally end wherever a tag occurs, 
     * and zero is not a valid tag number.
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
        
        // For protocol buffers, tags are encoded as varint
        int tag = firstByte & 0x7F;
        if ((firstByte & 0x80) == 0) {
            return tag;
        }
        
        // Handle multi-byte tag
        int shift = 7;
        while (shift < 32) {
            int nextByte = input.read();
            if (nextByte == -1) {
                throw new IOException("Malformed tag: truncated");
            }
            
            position++;
            tag |= (nextByte & 0x7F) << shift;
            
            if ((nextByte & 0x80) == 0) {
                return tag;
            }
            
            shift += 7;
        }
        
        // Tag is too long
        throw new IOException("Malformed tag: too many bytes");
    }
    
    /**
     * Gets the current position in the input stream
     */
    public int getPosition() {
        return position;
    }
}