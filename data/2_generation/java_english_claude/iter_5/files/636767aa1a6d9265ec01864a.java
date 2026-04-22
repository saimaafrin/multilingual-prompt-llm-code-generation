import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
    
    // Method to write bytes to the stream
    public void write(byte[] bytes) throws IOException {
        outputStream.write(bytes);
    }
    
    // Method to write a single byte
    public void write(int b) {
        outputStream.write(b);
    }
}