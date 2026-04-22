import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomByteArrayOutputStream extends ByteArrayOutputStream {

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
        // Ensure the buffer has enough space
        ensureCapacity(count + len);
        System.arraycopy(b, off, buf, count, len);
        count += len;
    }
}