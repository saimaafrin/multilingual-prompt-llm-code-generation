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
        
        int n = input.read(buffer);
        if (n <= 0) {
            return true;
        }
        pos = 0;
        bufferSize = n;
        return false;
    }

    private int readRawVarint32() throws IOException {
        byte tmp = readRawByte();
        if (tmp >= 0) {
            return tmp;
        }
        int result = tmp & 0x7f;
        if ((tmp = readRawByte()) >= 0) {
            result |= tmp << 7;
        } else {
            result |= (tmp & 0x7f) << 7;
            if ((tmp = readRawByte()) >= 0) {
                result |= tmp << 14;
            } else {
                result |= (tmp & 0x7f) << 14;
                if ((tmp = readRawByte()) >= 0) {
                    result |= tmp << 21;
                } else {
                    result |= (tmp & 0x7f) << 21;
                    result |= (tmp = readRawByte()) << 28;
                    if (tmp < 0) {
                        // Discard upper 32 bits.
                        for (int i = 0; i < 5; i++) {
                            if (readRawByte() >= 0) {
                                return result;
                            }
                        }
                        throw new IOException("Malformed varint");
                    }
                }
            }
        }
        return result;
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