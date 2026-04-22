import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;
    
    public void readFrom(final InputStream in) throws IOException {
        // Create output stream to store bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        // Read bytes from input stream in chunks
        byte[] chunk = new byte[4096];
        int bytesRead;
        
        while ((bytesRead = in.read(chunk)) != -1) {
            baos.write(chunk, 0, bytesRead);
        }
        
        // Convert to byte array and store in buffer
        buffer = baos.toByteArray();
        
        // Reset read pointer to start
        readPointer = 0;
        
        // Close streams
        baos.close();
    }
}