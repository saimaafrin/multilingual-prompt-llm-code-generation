import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream outputStream;

    public Buffer() {
        outputStream = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }
}