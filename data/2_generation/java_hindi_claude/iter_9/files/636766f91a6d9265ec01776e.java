import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamExtension extends ByteArrayOutputStream {

    /**
     * Writes <code>len</code> bytes from the specified byte array starting at offset <code>off</code> to this byte array output stream.
     * @param b   the data.
     * @param off the start offset in the data.
     * @param len the number of bytes to write.
     */
    @Override
    public synchronized void write(byte[] b, int off, int len) {
        if (b == null) {
            throw new NullPointerException();
        }
        
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }

        // Ensure capacity
        ensureCapacity(count + len);
        
        // Copy bytes from input array to internal buffer
        System.arraycopy(b, off, buf, count, len);
        
        // Update count
        count += len;
    }

    // Helper method to ensure buffer has enough capacity
    private void ensureCapacity(int minCapacity) {
        // If the capacity is not enough, grow the buffer
        if (minCapacity > buf.length) {
            // New capacity is max of minCapacity and 2 * current capacity
            int newCapacity = Math.max(minCapacity, buf.length * 2);
            byte[] newBuf = new byte[newCapacity];
            System.arraycopy(buf, 0, newBuf, 0, count);
            buf = newBuf;
        }
    }
}