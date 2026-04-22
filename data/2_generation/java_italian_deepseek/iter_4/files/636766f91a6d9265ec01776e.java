import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {

    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        for (int i = off; i < off + len; i++) {
            write(b[i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the logic to write a single byte to the output stream
        // For example, writing to a file or another output stream
        // This is a placeholder implementation
        System.out.write(b);
    }
}