import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayBuffer {
    private ByteArrayOutputStream buffer;
    
    public ByteArrayBuffer() {
        buffer = new ByteArrayOutputStream();
    }
    
    /**
     * Returns a single byte array containing all the contents written to the buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }
    
    // Helper method to write bytes to buffer
    public void write(byte[] bytes) throws IOException {
        buffer.write(bytes);
    }
    
    // Helper method to write single byte
    public void write(int b) {
        buffer.write(b);
    }
}