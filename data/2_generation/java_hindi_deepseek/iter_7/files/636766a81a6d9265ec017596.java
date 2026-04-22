import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[16]; // Initial capacity
        this.size = 0;
    }

    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + 4); // Ensure space for 4 bytes

        // Write the int value in big-endian order
        data[size++] = (byte) (intValue >> 24);
        data[size++] = (byte) (intValue >> 16);
        data[size++] = (byte) (intValue >> 8);
        data[size++] = (byte) intValue;

        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Optional: Add a method to get the current size of the vector
    public int size() {
        return size;
    }

    // Optional: Add a method to get the underlying byte array
    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}