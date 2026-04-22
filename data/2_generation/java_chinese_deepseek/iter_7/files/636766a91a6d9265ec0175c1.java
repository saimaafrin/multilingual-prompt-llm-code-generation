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
        this.data = newData;
        this.capacity = newCapacity;
    }

    public void add(byte b) {
        if (size >= capacity) {
            enlarge(1); // Enlarge by 1 if needed
        }
        data[size++] = b;
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }

    public static void main(String[] args) {
        ByteVector vector = new ByteVector(2);
        vector.add((byte) 1);
        vector.add((byte) 2);
        vector.add((byte) 3); // This will trigger enlargement
        byte[] result = vector.toByteArray();
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 3]
    }
}