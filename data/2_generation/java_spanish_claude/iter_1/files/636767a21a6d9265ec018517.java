import java.util.Arrays;

public class ByteArrayOutputStream {
    private byte[] buffer;
    private int count;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    public ByteArrayOutputStream() {
        this(32); // Default initial size
    }
    
    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        buffer = new byte[size];
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return Arrays.copyOf(buffer, count);
    }
    
    // Helper method to write bytes
    public synchronized void write(byte[] b, int off, int len) {
        if ((off < 0) || (off > b.length) || (len < 0) ||
            ((off + len) - b.length > 0)) {
            throw new IndexOutOfBoundsException();
        }
        
        ensureCapacity(count + len);
        System.arraycopy(b, off, buffer, count, len);
        count += len;
    }
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - buffer.length > 0) {
            grow(minCapacity);
        }
    }
    
    private void grow(int minCapacity) {
        int oldCapacity = buffer.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        buffer = Arrays.copyOf(buffer, newCapacity);
    }
    
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
}