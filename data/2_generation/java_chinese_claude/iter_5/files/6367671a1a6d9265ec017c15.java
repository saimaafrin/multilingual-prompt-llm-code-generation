import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Initial capacity
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
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
            // Fill with zeros if input array is null
            Arrays.fill(data, length, length + byteLength, (byte) 0);
        }
        
        length += byteLength;
        return this;
    }

    // Helper methods
    public byte[] getData() {
        return Arrays.copyOf(data, length);
    }

    public int getLength() {
        return length;
    }
}