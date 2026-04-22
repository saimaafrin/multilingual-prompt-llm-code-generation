import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;
    private int size;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        int newCapacity = capacity + size;
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void add(byte b) {
        if (size == capacity) {
            enlarge(1);
        }
        data[size++] = b;
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }
}