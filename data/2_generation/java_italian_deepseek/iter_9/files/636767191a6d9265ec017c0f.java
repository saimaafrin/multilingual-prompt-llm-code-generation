import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
    }

    private void enlarge(final int size) {
        int newCapacity = capacity + size;
        byte[] newData = Arrays.copyOf(data, newCapacity);
        this.data = newData;
        this.capacity = newCapacity;
    }

    // Other methods of the ByteVector class can be added here
}