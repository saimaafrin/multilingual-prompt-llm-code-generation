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
     * Restituisce un singolo array di byte contenente tutti i contenuti scritti nel/i buffer.
     */
    public final byte[] toByteArray() {
        return Arrays.copyOf(buffer, count);
    }
    
    // Helper method to ensure capacity
    private void ensureCapacity(int minCapacity) {
        if (minCapacity - buffer.length > 0) {
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
    }
    
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }
}