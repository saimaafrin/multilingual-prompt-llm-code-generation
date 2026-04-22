import java.io.IOException;
import java.io.InputStream;

public class CodecInputStream {
    private final InputStream input;
    private int lastTag = 0;
    private int position = 0;
    
    public CodecInputStream(InputStream input) {
        this.input = input;
    }

    public int readTag() throws IOException {
        if (input.available() == 0) {
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

    private int readRawVarint32() throws IOException {
        byte tmp = (byte) input.read();
        if (tmp >= 0) {
            return tmp;
        }
        int result = tmp & 0x7f;
        if ((tmp = (byte) input.read()) >= 0) {
            result |= tmp << 7;
        } else {
            result |= (tmp & 0x7f) << 7;
            if ((tmp = (byte) input.read()) >= 0) {
                result |= tmp << 14;
            } else {
                result |= (tmp & 0x7f) << 14;
                if ((tmp = (byte) input.read()) >= 0) {
                    result |= tmp << 21;
                } else {
                    result |= (tmp & 0x7f) << 21;
                    result |= (tmp = (byte) input.read()) << 28;
                    if (tmp < 0) {
                        // Discard upper 32 bits.
                        for (int i = 0; i < 5; i++) {
                            if (input.read() >= 0) {
                                position++;
                                return result;
                            }
                        }
                        throw new IOException("Malformed varint");
                    }
                }
            }
        }
        position++;
        return result;
    }
}