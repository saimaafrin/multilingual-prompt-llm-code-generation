import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayBuffer {
    private ByteArrayOutputStream outputStream;

    public ByteArrayBuffer() {
        outputStream = new ByteArrayOutputStream();
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }

    // Helper method to write bytes to the buffer
    public void write(byte[] bytes) throws IOException {
        outputStream.write(bytes);
    }

    // Helper method to write a single byte
    public void write(int b) {
        outputStream.write(b);
    }
}