import java.io.IOException;

public class FieldParser {
    private boolean isPacked = false;
    private int currentPosition = 0;
    private byte[] buffer;
    
    /**
     * Check if this field have been packed into a length-delimited field. If so, update internal state to reflect that packed fields are being read.
     * @throws IOException if there is an error reading from the buffer
     */
    private void checkIfPackedField() throws IOException {
        if (currentPosition >= buffer.length) {
            throw new IOException("Buffer overflow - cannot read beyond buffer length");
        }

        // Check if next byte indicates packed field (MSB set)
        byte nextByte = buffer[currentPosition];
        if ((nextByte & 0x80) != 0) {
            isPacked = true;
            // Skip the length byte
            currentPosition++;
        } else {
            isPacked = false;
        }
    }
    
    // Constructor and other methods
    public FieldParser(byte[] buffer) {
        this.buffer = buffer;
    }
    
    public boolean getIsPacked() {
        return isPacked;
    }
    
    public int getCurrentPosition() {
        return currentPosition;
    }
}