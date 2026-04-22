import java.io.IOException;
import java.io.InputStream;

public class CodedInputStream {
    private final InputStream input;
    private int lastTag = 0;
    private int pos = 0;
    private byte[] buffer;
    private int bufferSize;
    private static final int BUFFER_SIZE = 4096;

    public CodedInputStream(InputStream input) {
        this.input = input;
        this.buffer = new byte[BUFFER_SIZE];
        this.bufferSize = 0;
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            lastTag = 0;
            return 0;
        }

        // Read the tag value using variable-length encoding
        lastTag = readVarint32();
        
        if (lastTag == 0) {
            // If we read zero, that means either:
            // 1) We hit EOF, or
            // 2) We read a zero byte (invalid tag)
            throw new IOException("Invalid tag: zero");
        }

        return lastTag;
    }

    private boolean isAtEnd() throws IOException {
        if (pos < bufferSize) {
            return false;
        }
        
        int n = input.read(buffer);
        if (n <= 0) {
            return true;
        }
        
        pos = 0;
        bufferSize = n;
        return false;
    }

    private int readVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        
        while (shift < 32) {
            byte b = readRawByte();
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        
        throw new IOException("Malformed varint32");
    }

    private byte readRawByte() throws IOException {
        if (pos == bufferSize) {
            int n = input.read(buffer);
            if (n <= 0) {
                throw new IOException("EOF");
            }
            pos = 0;
            bufferSize = n;
        }
        return buffer[pos++];
    }
}