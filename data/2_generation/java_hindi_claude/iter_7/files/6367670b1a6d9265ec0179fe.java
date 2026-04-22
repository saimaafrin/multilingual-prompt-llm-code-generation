import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {
    
    private byte[] buffer;
    private int pos;
    
    public ByteOutputStream() {
        buffer = new byte[32]; // Initial buffer size
        pos = 0;
    }

    public void write(byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        // Ensure buffer has enough capacity
        ensureCapacity(pos + b.length);
        
        // Copy bytes to buffer
        System.arraycopy(b, 0, buffer, pos, b.length);
        pos += b.length;
    }
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            // Grow buffer by doubling size
            int newCapacity = Math.max(buffer.length * 2, minCapacity);
            byte[] newBuffer = new byte[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, pos);
            buffer = newBuffer;
        }
    }
    
    @Override
    public void write(int b) throws IOException {
        ensureCapacity(pos + 1);
        buffer[pos++] = (byte)b;
    }
    
    public byte[] toByteArray() {
        byte[] result = new byte[pos];
        System.arraycopy(buffer, 0, result, 0, pos);
        return result;
    }
}