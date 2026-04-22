import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private byte[] buf;
    private int count;
    private static final int DEFAULT_SIZE = 32;

    public ByteArrayOutputStream() {
        buf = new byte[DEFAULT_SIZE];
    }

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        // Ensure capacity
        ensureCapacity(count + b.length);
        
        // Copy bytes to internal buffer
        System.arraycopy(b, 0, buf, count, b.length);
        count += b.length;
    }

    private void ensureCapacity(int minCapacity) {
        // If the capacity is not enough, grow the buffer
        if (minCapacity > buf.length) {
            int newCapacity = Math.max(buf.length << 1, minCapacity);
            byte[] newBuf = new byte[newCapacity];
            System.arraycopy(buf, 0, newBuf, 0, count);
            buf = newBuf;
        }
    }
}