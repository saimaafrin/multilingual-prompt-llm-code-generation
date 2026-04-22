import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    private static final int DEFAULT_INITIAL_SIZE = 64;

    public ByteVector() {
        data = new byte[DEFAULT_INITIAL_SIZE];
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength == 0) {
            return this;
        }

        // Ensure capacity
        int requiredLength = length + byteLength;
        if (requiredLength > data.length) {
            int newCapacity = Math.max(2 * data.length, requiredLength);
            data = Arrays.copyOf(data, newCapacity);
        }

        if (byteArrayValue != null) {
            System.arraycopy(byteArrayValue, byteOffset, data, length, byteLength);
        } else {
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