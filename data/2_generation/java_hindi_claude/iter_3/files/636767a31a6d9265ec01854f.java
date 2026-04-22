import java.io.IOException;

public class FieldReader {
    private boolean isPacked;
    private int currentPosition;
    private byte[] buffer;
    
    /**
     * Check if this field have been packed into a length-delimited field. If so, update internal state to reflect that packed fields are being read.
     * @throws IOException if there is an error reading from the buffer
     */
    private void checkIfPackedField() throws IOException {
        if (currentPosition >= buffer.length) {
            throw new IOException("Buffer overflow");
        }
        
        // Check if next byte indicates packed field
        byte tag = buffer[currentPosition];
        if ((tag & 0x07) == 2) { // Wire type 2 indicates length-delimited
            isPacked = true;
            currentPosition++; // Move past tag byte
            
            // Read length
            int length = 0;
            int shift = 0;
            while (true) {
                if (currentPosition >= buffer.length) {
                    throw new IOException("Invalid packed field length");
                }
                byte b = buffer[currentPosition++];
                length |= (b & 0x7F) << shift;
                if ((b & 0x80) == 0) {
                    break;
                }
                shift += 7;
            }
            
            // Validate length
            if (currentPosition + length > buffer.length) {
                throw new IOException("Invalid packed field length");
            }
        } else {
            isPacked = false;
        }
    }
}