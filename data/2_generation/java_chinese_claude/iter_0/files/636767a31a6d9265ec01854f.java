import java.io.IOException;
import java.io.InputStream;

public class WireFormatDecoder {
    private static final int WIRETYPE_LENGTH_DELIMITED = 2;
    private static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = (1 << TAG_TYPE_BITS) - 1;
    
    private final InputStream input;
    private int tag;
    private int wireType;
    private boolean isPacked;
    private int packedLimit;
    private int currentLimit;
    
    public WireFormatDecoder(InputStream input) {
        this.input = input;
        this.isPacked = false;
        this.packedLimit = 0;
        this.currentLimit = Integer.MAX_VALUE;
    }

    private void checkIfPackedField() throws IOException {
        // Check if this field should be packed based on wire type
        if (wireType == WIRETYPE_LENGTH_DELIMITED) {
            // Read the length of the packed data
            int length = readRawVarint32();
            
            if (length > 0) {
                // Store current position as packed limit
                packedLimit = currentLimit;
                // Update current limit to end of packed data
                currentLimit = packedLimit + length;
                isPacked = true;
            }
        } else {
            // Not a packed field
            isPacked = false;
        }
    }
    
    private int readRawVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        while (shift < 32) {
            int b = input.read();
            if (b == -1) {
                throw new IOException("Unexpected EOF while reading varint");
            }
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint");
    }
}