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
}