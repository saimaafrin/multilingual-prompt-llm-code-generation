import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        buffer.write(data);
    }

    /**
     * Restituisce un singolo array di byte contenente tutti i contenuti scritti nel/i buffer.
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }
}