import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    private static final int DEFAULT_CAPACITY = 16;

    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        length = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        // Validate input parameters
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength cannot be negative");
        }
        if (byteArrayValue != null) {
            if (byteOffset < 0 || byteOffset > byteArrayValue.length) {
                throw new IllegalArgumentException("Invalid byteOffset");
            }
            if (byteOffset + byteLength > byteArrayValue.length) {
                throw new IllegalArgumentException("byteOffset + byteLength exceeds array bounds");
            }
        }

        // Ensure capacity
        ensureCapacity(length + byteLength);

        // Copy bytes
        if (byteArrayValue == null) {
            // Fill with null bytes
            Arrays.fill(data, length, length + byteLength, (byte) 0);
        } else {
            // Copy from source array
            System.arraycopy(byteArrayValue, byteOffset, data, length, byteLength);
        }

        length += byteLength;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Getter for testing purposes
    public byte[] getData() {
        return Arrays.copyOf(data, length);
    }
}