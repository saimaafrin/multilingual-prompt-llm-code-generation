import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private final ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        buffer.write(data);
    }

    /**
     * Returns a single byte array containing all the contents written to the buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }
}