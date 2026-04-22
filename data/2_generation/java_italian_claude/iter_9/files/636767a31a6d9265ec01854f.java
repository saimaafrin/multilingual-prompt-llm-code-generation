import java.io.IOException;

public class FieldReader {
    private boolean isCompressed;
    private int compressedLength;
    private int currentPosition;
    private byte[] buffer;

    /**
     * Controlla se questo campo è stato compresso in un campo delimitato da lunghezza. 
     * In tal caso, aggiorna lo stato interno per riflettere che i campi compressi stanno per essere letti.
     * @throws IOException
     */
    private void checkIfPackedField() throws IOException {
        if (currentPosition < buffer.length - 4) {
            // Check for compression marker bytes
            if (buffer[currentPosition] == 0x1F && buffer[currentPosition + 1] == 0x8B) {
                // Found GZIP compression header
                isCompressed = true;
                
                // Read compressed length from next 4 bytes
                compressedLength = ((buffer[currentPosition + 2] & 0xFF) << 24) |
                                 ((buffer[currentPosition + 3] & 0xFF) << 16) |
                                 ((buffer[currentPosition + 4] & 0xFF) << 8) |
                                 (buffer[currentPosition + 5] & 0xFF);
                
                // Skip compression header
                currentPosition += 6;
            } else {
                isCompressed = false;
                compressedLength = 0;
            }
        } else {
            throw new IOException("Buffer overflow while checking for packed field");
        }
    }
}