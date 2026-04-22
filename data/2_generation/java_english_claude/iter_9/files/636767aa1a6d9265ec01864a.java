import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayConverter {
    private ByteArrayOutputStream outputStream;
    
    public ByteArrayConverter() {
        outputStream = new ByteArrayOutputStream();
    }
    
    /**
     * Copies bytes to a {@code byte[]}.
     * @return byte array containing the bytes
     */
    public byte[] toByteArray() {
        if (outputStream == null) {
            return new byte[0];
        }
        return outputStream.toByteArray();
    }
    
    // Helper method to write bytes to the stream
    public void write(byte[] bytes) {
        try {
            outputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException("Error writing bytes to stream", e);
        }
    }
}