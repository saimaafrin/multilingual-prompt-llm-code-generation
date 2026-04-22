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
        try {
            buffer.flush();
            return buffer.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }

    // Other methods for writing to buffer would go here
}