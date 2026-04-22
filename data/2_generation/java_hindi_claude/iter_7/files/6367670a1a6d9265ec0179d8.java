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
        if (b == null) {
            throw new NullPointerException();
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        
        // Write bytes one at a time
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