import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class BufferUtils {

    private final ByteBuffer[] buffers;

    public BufferUtils(ByteBuffer[] buffers) {
        this.buffers = buffers;
    }

    public final byte[] toByteArray() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            for (ByteBuffer buffer : buffers) {
                if (buffer.hasArray()) {
                    outputStream.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
                } else {
                    byte[] temp = new byte[buffer.remaining()];
                    buffer.get(temp);
                    outputStream.write(temp);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write buffer contents to byte array", e);
        }
        return outputStream.toByteArray();
    }
}