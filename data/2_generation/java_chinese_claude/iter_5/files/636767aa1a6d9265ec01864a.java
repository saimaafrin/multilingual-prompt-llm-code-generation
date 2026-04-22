import java.util.Arrays;

public class ByteArrayConverter {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public ByteArrayConverter() {
        data = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * 将字节复制到 {@code byte[]} 中。
     */
    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }

    // Helper methods to add bytes
    public void add(byte b) {
        ensureCapacity(size + 1);
        data[size++] = b;
    }

    public void add(byte[] bytes) {
        ensureCapacity(size + bytes.length);
        System.arraycopy(bytes, 0, data, size, bytes.length);
        size += bytes.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}