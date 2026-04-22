import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomByteArrayOutputStream extends ByteArrayOutputStream {

    /**
     * Writes <code>len</code> bytes from the specified byte array starting at offset <code>off</code> to this byte array output stream.
     * @param b   the data.
     * @param off the start offset in the data.
     * @param len the number of bytes to write.
     */
    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        if (len == 0) {
            return; // No bytes to write
        }
        super.write(b, off, len);
    }
}