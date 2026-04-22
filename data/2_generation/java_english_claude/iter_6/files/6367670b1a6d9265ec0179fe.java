import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private byte[] buf;
    private int count;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Writes <code>b.length</code> bytes from the specified byte array to this output stream.
     * @param b The array of bytes to be written.
     * @exception IOException if an error occurs.
     */
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        int newcount = count + b.length;
        if (newcount > buf.length) {
            grow(newcount);
        }
        System.arraycopy(b, 0, buf, count, b.length);
        count = newcount;
    }

    private void grow(int minCapacity) {
        int oldCapacity = buf.length;
        int newCapacity = oldCapacity << 1;
        
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        
        buf = Arrays.copyOf(buf, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }
}