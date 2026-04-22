import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BufferUtils {

    /**
     * Restituisce un singolo array di byte contenente tutti i contenuti scritti nel/i buffer.
     */
    public static byte[] toByteArray(ByteBuffer... buffers) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            for (ByteBuffer buffer : buffers) {
                if (buffer.hasArray()) {
                    outputStream.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
                } else {
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    outputStream.write(data);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write buffer contents to byte array", e);
        }
        return outputStream.toByteArray();
    }
}