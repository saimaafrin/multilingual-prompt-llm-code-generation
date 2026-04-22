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

        lastTag = readRawVarint32();
        if (lastTag == 0) {
            // If we actually read zero, that's not a valid tag.
            throw new IOException("Invalid tag: zero is not a valid tag value");
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

    private int readRawVarint32() throws IOException {
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
        throw new IOException("Malformed varint");
    }

    private byte readRawByte() throws IOException {
        if (pos == bufferSize) {
            int n = input.read(buffer);
            if (n <= 0) {
                throw new IOException("End of input");
            }
            pos = 0;
            bufferSize = n;
        }
        return buffer[pos++];
    }
}