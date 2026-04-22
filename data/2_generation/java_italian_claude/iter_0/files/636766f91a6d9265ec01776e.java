import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {

    private byte[] buffer;
    private int position;
    
    public ByteOutputStream() {
        buffer = new byte[32]; // Initial buffer size
        position = 0;
    }

    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }

        // Ensure buffer has enough capacity
        ensureCapacity(position + len);
        
        // Copy bytes from input array to buffer
        System.arraycopy(b, off, buffer, position, len);
        position += len;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            // Grow buffer by doubling size
            int newCapacity = Math.max(buffer.length * 2, minCapacity);
            byte[] newBuffer = new byte[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, position);
            buffer = newBuffer;
        }
    }

    // Other required OutputStream methods would go here
    @Override
    public void write(int b) throws IOException {
        ensureCapacity(position + 1);
        buffer[position++] = (byte)b;
    }
}