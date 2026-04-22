import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new byte[initialCapacity];
    }

    /** 
     * Enlarges this byte vector so that it can receive 'size' more bytes.
     * @param size number of additional bytes that this byte vector should be able to receive.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newCapacity = capacity + size;
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }
}