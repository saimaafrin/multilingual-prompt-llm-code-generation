import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayBuffer {
    private ByteArrayOutputStream buffer;

    public ByteArrayBuffer() {
        buffer = new ByteArrayOutputStream();
    }

    /**
     * Returns a single byte array containing all the contents written to the buffer(s).
     * @return byte array containing buffer contents
     */
    public byte[] toByteArray() {
        try {
            buffer.flush();
            return buffer.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }

    // Additional methods for writing to buffer would go here
    public void write(byte[] bytes) throws IOException {
        buffer.write(bytes);
    }

    public void write(int b) throws IOException {
        buffer.write(b);
    }

    public void write(byte[] bytes, int offset, int length) throws IOException {
        buffer.write(bytes, offset, length);
    }
}