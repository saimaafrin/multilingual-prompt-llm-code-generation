import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Initial capacity
        length = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        // Ensure capacity
        int requiredLength = length + byteLength;
        if (requiredLength > data.length) {
            int newCapacity = Math.max(2 * data.length, requiredLength);
            data = Arrays.copyOf(data, newCapacity);
        }

        if (byteArrayValue != null) {
            // Copy bytes from input array
            System.arraycopy(byteArrayValue, byteOffset, data, length, byteLength);
        } else {
            // Fill with null bytes
            Arrays.fill(data, length, length + byteLength, (byte) 0);
        }

        length += byteLength;
        return this;
    }
}