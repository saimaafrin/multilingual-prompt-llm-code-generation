import java.io.IOException;
import java.io.InputStream;

public class CodedInputStream {
    private final InputStream input;
    private int lastTag = 0;
    private int pos = 0;
    private byte[] buffer;
    private int bufferSize;
    
    public CodedInputStream(InputStream input) {
        this.input = input;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            lastTag = 0;
            return 0;
        }

        lastTag = readRawVarint32();
        if (lastTag == 0) {
            // If we actually read zero, that's not a valid tag.
            throw new IOException("Invalid tag: zero");
        }
        return lastTag;
    }

    private boolean isAtEnd() throws IOException {
        if (pos < bufferSize) {
            return false;
        }
        
        int read = input.read(buffer);
        if (read <= 0) {
            return true;
        }
        
        pos = 0;
        bufferSize = read;
        return false;
    }

    private int readRawVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        
        while (shift < 32) {
            if (pos >= bufferSize) {
                int read = input.read(buffer);
                if (read <= 0) {
                    throw new IOException("Truncated message");
                }
                pos = 0;
                bufferSize = read;
            }
            
            byte b = buffer[pos++];
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        
        throw new IOException("Malformed varint");
    }
}