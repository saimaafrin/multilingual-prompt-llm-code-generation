import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    
    protected byte[] buf;
    protected int count;
    
    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
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
        count += len;
    }
    
    private void ensureCapacity(int minCapacity) {
        // If the capacity is not enough
        if (minCapacity > buf.length) {
            // Grow buffer
            int newCapacity = Math.max(buf.length << 1, minCapacity);
            byte[] newBuf = new byte[newCapacity];
            System.arraycopy(buf, 0, newBuf, 0, count);
            buf = newBuf;
        }
    }
}