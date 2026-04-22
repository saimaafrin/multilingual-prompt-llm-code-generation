import java.io.IOException;
import java.io.InputStream;

public class WireFormatDecoder {
    private static final int WIRETYPE_LENGTH_DELIMITED = 2;
    private static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = (1 << TAG_TYPE_BITS) - 1;
    
    private final InputStream input;
    private int tag;
    private boolean isPacked;
    private int packedLimit;
    private int currentLimit;
    
    public WireFormatDecoder(InputStream input) {
        this.input = input;
        this.currentLimit = Integer.MAX_VALUE;
    }

    private void checkIfPackedField() throws IOException {
        if ((tag & TAG_TYPE_MASK) == WIRETYPE_LENGTH_DELIMITED) {
            int length = readRawVarint32();
            if (length > 0) {
                isPacked = true;
                packedLimit = currentLimit;
                currentLimit = currentLimit - length;
            }
        } else {
            isPacked = false;
        }
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
}