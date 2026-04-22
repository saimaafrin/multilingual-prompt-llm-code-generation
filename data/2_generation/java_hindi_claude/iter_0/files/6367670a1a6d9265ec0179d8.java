import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriter {
    /**
     * @see OutputStream#write(byte[])
     */
    public void write(byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        write(b, 0, b.length);
    }

    /**
     * Helper method to write bytes from an offset
     */
    private void write(byte[] b, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }

    /**
     * Write a single byte
     */
    private void write(int b) throws IOException {
        // Implementation would depend on underlying output stream
        throw new UnsupportedOperationException("Not implemented");
    }
}