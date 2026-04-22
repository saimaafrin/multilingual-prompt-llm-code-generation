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

    /**
     * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
     * @param size 此字节向量应该能够接收的额外字节数。
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }

        int newCapacity = capacity + size;
        byte[] newData = Arrays.copyOf(data, newCapacity);
        data = newData;
        capacity = newCapacity;
    }

    // Example usage
    public static void main(String[] args) {
        ByteVector vector = new ByteVector(10);
        vector.enlarge(5);
        System.out.println("New capacity: " + vector.capacity);
    }
}