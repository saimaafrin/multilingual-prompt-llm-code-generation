import java.io.IOException;
import java.io.InputStream;

public class WireFormatDecoder {
    private static final int WIRETYPE_LENGTH_DELIMITED = 2;
    private static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = (1 << TAG_TYPE_BITS) - 1;
    
    private final InputStream input;
    private int tag;
    private int lastTag;
    private boolean packedFieldMode;
    private int packedFieldEndPos;
    private int currentPosition;
    
    public WireFormatDecoder(InputStream input) {
        this.input = input;
    }

    private void checkIfPackedField() throws IOException {
        // Check if current field is length-delimited (packed field)
        if ((tag & TAG_TYPE_MASK) == WIRETYPE_LENGTH_DELIMITED) {
            // Read packed field length
            int length = readVarint32();
            
            // Set packed field mode and calculate end position
            packedFieldMode = true;
            packedFieldEndPos = currentPosition + length;
            
            // Read first tag inside packed field
            tag = readVarint32();
        } else {
            packedFieldMode = false;
        }
        
        lastTag = tag;
    }
    
    // Helper method to read variable length 32-bit integer
    private int readVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        while (shift < 32) {
            int b = input.read();
            currentPosition++;
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint32");
    }
}