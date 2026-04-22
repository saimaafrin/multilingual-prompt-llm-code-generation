import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;
    
    /**
     * Clear and fill the buffer with the supplied byte stream. 
     * The read pointer is reset to the start of the byte array.
     *
     * @param inputStream the input stream to read bytes from
     * @throws IOException if an I/O error occurs while reading the stream
     */
    public void fillBuffer(InputStream inputStream) throws IOException {
        // Create output stream to store bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        // Read bytes from input stream
        byte[] tempBuffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(tempBuffer)) != -1) {
            outputStream.write(tempBuffer, 0, bytesRead);
        }
        
        // Clear existing buffer and store new bytes
        buffer = outputStream.toByteArray();
        
        // Reset read pointer to start
        readPointer = 0;
        
        // Close streams
        outputStream.close();
    }
}