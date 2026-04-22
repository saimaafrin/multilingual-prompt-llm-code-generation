import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {

    private byte[] buffer;
    private int count;
    
    public ByteOutputStream() {
        buffer = new byte[32];
        count = 0;
    }

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
        
        // Copy bytes to internal buffer
        System.arraycopy(b, off, buffer, count, len);
        count += len;
    }

    private void ensureCapacity(int minCapacity) {
        // If buffer is too small, grow it
        if (minCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length << 1, minCapacity);
            byte[] newBuffer = new byte[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, count);
            buffer = newBuffer;
        }
    }

    // Other required methods for OutputStream...
    @Override
    public void write(int b) throws IOException {
        ensureCapacity(count + 1);
        buffer[count] = (byte) b;
        count += 1;
    }
}