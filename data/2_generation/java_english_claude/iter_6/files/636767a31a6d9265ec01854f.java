import java.io.IOException;
import java.io.InputStream;

public class ProtobufReader {
    private InputStream input;
    private int currentTag;
    private boolean isPacked;
    private int packedEndPos;
    private int currentPos;

    private void checkIfPackedField() throws IOException {
        // Check if the current field is length-delimited (wire type = 2)
        if ((currentTag & 0x7) == 2) {
            // Read the length of the packed field
            int length = readVarint32();
            
            // Mark the end position of packed data
            packedEndPos = currentPos + length;
            
            // Set packed flag
            isPacked = true;
        } else {
            // Not a packed field
            isPacked = false;
            packedEndPos = -1;
        }
    }

    // Helper method to read variable length 32-bit integer
    private int readVarint32() throws IOException {
        int result = 0;
        int shift = 0;
        
        while (shift < 32) {
            int b = input.read();
            currentPos++;
            
            result |= (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint32");
    }
}