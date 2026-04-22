import java.io.IOException;
import java.io.InputStream;

public class CodedInputStream {
    private final InputStream input;
    private int lastTag = 0;
    private int pos = 0;
    private byte[] buffer;
    private static final int BUFFER_SIZE = 4096;

    public CodedInputStream(InputStream input) {
        this.input = input;
        this.buffer = new byte[BUFFER_SIZE];
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
            // 2) We read a zero byte (corrupt data)
            // Either way, we return zero to indicate no more data
            return 0;
        }

        return lastTag;
    }

    private boolean isAtEnd() throws IOException {
        if (pos < buffer.length) {
            return false;
        }
        int result = input.read();
        if (result == -1) {
            return true;
        }
        pos = 0;
        buffer[pos++] = (byte) result;
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
        if (pos == buffer.length) {
            int n = input.read(buffer);
            if (n == -1) {
                throw new IOException("EOF reached");
            }
            pos = 0;
        }
        return buffer[pos++];
    }
}