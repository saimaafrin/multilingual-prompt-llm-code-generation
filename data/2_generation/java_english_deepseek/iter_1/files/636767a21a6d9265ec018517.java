import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        try {
            buffer.write(data);
        } catch (IOException e) {
            // Handle the exception, though ByteArrayOutputStream.write() does not throw IOException
            e.printStackTrace();
        }
    }

    /**
     * Returns a single byte array containing all the contents written to the buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }
}