import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayConverter {
    private ByteArrayOutputStream outputStream;

    public ByteArrayConverter() {
        this.outputStream = new ByteArrayOutputStream();
    }

    /**
     * Copies bytes to a {@code byte[]}.
     * @return byte array containing the bytes
     */
    public byte[] toByteArray() {
        return outputStream.toByteArray();
    }
}