import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        try {
            buffer.write(data);
        } catch (IOException e) {
            // Handle the exception, though ByteArrayOutputStream.write(byte[]) does not throw IOException
            e.printStackTrace();
        }
    }

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }
}