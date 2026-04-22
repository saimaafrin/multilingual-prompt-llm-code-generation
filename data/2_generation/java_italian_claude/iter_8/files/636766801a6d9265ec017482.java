import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ClassFileBuffer {
    private byte[] buffer;
    private int position;
    private static final int INITIAL_BUFFER_SIZE = 4096;
    
    public void readFrom(final InputStream in) throws IOException {
        // Reset buffer and position
        buffer = new byte[INITIAL_BUFFER_SIZE];
        position = 0;
        
        int bytesRead;
        int totalBytes = 0;
        
        // Read bytes from input stream into buffer
        while ((bytesRead = in.read(buffer, totalBytes, buffer.length - totalBytes)) != -1) {
            totalBytes += bytesRead;
            
            // If buffer is full, expand it
            if (totalBytes >= buffer.length) {
                buffer = Arrays.copyOf(buffer, buffer.length * 2);
            }
        }
        
        // Trim buffer to actual size
        if (totalBytes < buffer.length) {
            buffer = Arrays.copyOf(buffer, totalBytes);
        }
        
        // Reset read position to start
        position = 0;
    }
}