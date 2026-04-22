import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /** 
     * Enlarges this byte vector so that it can receive 'size' more bytes.
     * @param size number of additional bytes that this byte vector should be able to receive.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = currentSize + size;
        data = Arrays.copyOf(data, newSize);
    }

    // Additional methods for demonstration purposes
    public void add(byte b) {
        if (currentSize == data.length) {
            enlarge(1);
        }
        data[currentSize++] = b;
    }

    public byte get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public int size() {
        return currentSize;
    }
}