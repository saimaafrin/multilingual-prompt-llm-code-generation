import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
    }

    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        int newCapacity = capacity + size;
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public byte[] getData() {
        return data;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        ByteVector vector = new ByteVector(10);
        System.out.println("Initial Capacity: " + vector.getCapacity());
        vector.enlarge(5);
        System.out.println("New Capacity: " + vector.getCapacity());
    }
}