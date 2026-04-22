import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    private byte[] buffer;
    private int position;

    public CustomOutputStream(int size) {
        buffer = new byte[size];
        position = 0;
    }

    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        if (position + len > buffer.length) {
            throw new IOException("Not enough space in buffer");
        }
        System.arraycopy(b, off, buffer, position, len);
        position += len;
    }

    // Additional methods for demonstration purposes
    public byte[] getBuffer() {
        return buffer;
    }

    public int getPosition() {
        return position;
    }
}