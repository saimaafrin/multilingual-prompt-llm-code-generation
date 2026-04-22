import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[16]; // Initial capacity
        this.size = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength must be non-negative");
        }
        if (byteOffset < 0) {
            throw new IllegalArgumentException("byteOffset must be non-negative");
        }
        if (byteArrayValue != null && (byteOffset + byteLength > byteArrayValue.length)) {
            throw new IllegalArgumentException("byteOffset + byteLength exceeds byteArrayValue length");
        }

        ensureCapacity(size + byteLength);

        if (byteArrayValue == null) {
            // Fill with null bytes (0x00)
            Arrays.fill(data, size, size + byteLength, (byte) 0);
        } else {
            // Copy the specified bytes from byteArrayValue
            System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        }

        size += byteLength;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Optional: Add a method to get the current data as a byte array
    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}