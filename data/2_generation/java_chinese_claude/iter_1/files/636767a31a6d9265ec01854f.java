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
        // Check if the field has packed encoding by examining the wire type
        if (getWireType(tag) == WIRETYPE_LENGTH_DELIMITED) {
            int length = readRawVarint32();
            if (length < 0) {
                throw new IOException("Negative length for packed field");
            }
            
            // Set the packed field limit
            packedLimit = pushLimit(length);
            isPacked = true;
        } else {
            isPacked = false;
        }
    }
    
    private int getWireType(int tag) {
        return tag & TAG_TYPE_MASK;
    }
    
    private int readRawVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        while (shift < 32) {
            int b = input.read();
            if (b == -1) {
                throw new IOException("Truncated message");
            }
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint");
    }
    
    private int pushLimit(int limit) {
        int oldLimit = currentLimit;
        currentLimit = Math.min(oldLimit, limit);
        return oldLimit;
    }
}