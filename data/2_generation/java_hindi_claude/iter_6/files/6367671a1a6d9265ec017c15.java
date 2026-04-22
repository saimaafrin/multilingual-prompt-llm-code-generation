import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    private static final int DEFAULT_CAPACITY = 64;

    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        if (byteOffset < 0) {
            throw new IllegalArgumentException("Offset cannot be negative"); 
        }
        if (byteArrayValue != null && byteOffset + byteLength > byteArrayValue.length) {
            throw new IllegalArgumentException("Array length exceeded");
        }

        // Ensure capacity
        int requiredLength = length + byteLength;
        if (requiredLength > data.length) {
            int newCapacity = Math.max(2 * data.length, requiredLength);
            data = Arrays.copyOf(data, newCapacity);
        }

        // Copy bytes
        if (byteArrayValue != null) {
            System.arraycopy(byteArrayValue, byteOffset, data, length, byteLength);
        } else {
            // Fill with null bytes if input array is null
            Arrays.fill(data, length, length + byteLength, (byte) 0);
        }

        length += byteLength;
        return this;
    }

    // Getter for testing
    public byte[] getData() {
        return Arrays.copyOf(data, length);
    }
}