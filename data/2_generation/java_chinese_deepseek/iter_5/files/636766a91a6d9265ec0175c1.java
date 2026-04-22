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
        int newCapacity = capacity + size;
        if (newCapacity < 0) { // Handle overflow
            throw new OutOfMemoryError("Required array size too large");
        }
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    // Other methods of ByteVector class...
}