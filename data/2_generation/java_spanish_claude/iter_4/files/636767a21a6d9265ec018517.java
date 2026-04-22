import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayBuffer {
    private ByteArrayOutputStream buffer;

    public ByteArrayBuffer() {
        buffer = new ByteArrayOutputStream();
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    // Helper method to write bytes to buffer
    public void write(byte[] bytes) {
        try {
            buffer.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to buffer", e);
        }
    }

    // Helper method to write a single byte
    public void write(int b) {
        buffer.write(b);
    }
}