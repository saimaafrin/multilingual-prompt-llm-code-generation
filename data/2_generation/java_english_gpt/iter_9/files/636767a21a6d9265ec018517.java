import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private final ByteArrayOutputStream outputStream;

    public Buffer() {
        this.outputStream = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    /** 
     * Returns a single byte array containing all the contents written to the buffer(s).
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }
}