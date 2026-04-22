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
        
        while (true) {
            int byte1 = input.read();
            if (byte1 == -1) {
                // EOF reached
                return shift == 0 ? 0 : tag;
            }
            
            tag |= (byte1 & 0x7F) << shift;
            if ((byte1 & 0x80) == 0) {
                break;
            }
            shift += 7;
            if (shift >= 32) {
                throw new IOException("Tag is too large");
            }
        }
        
        position++;
        return tag;
    }
    
    public int getPosition() {
        return position;
    }
}