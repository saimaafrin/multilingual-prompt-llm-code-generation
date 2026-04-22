import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        // Implementation for writing a single byte
    }

    /**
     * @see OutputStream#write(byte[])
     */
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }

    @Override
    public void flush() throws IOException {
        // Implementation for flushing the stream
    }

    @Override
    public void close() throws IOException {
        // Implementation for closing the stream
    }
}