import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        // Ensure capacity
        ensureCapacity(size + byteLength);
        
        // If input array is null, add null bytes
        if (byteArrayValue == null) {
            for (int i = 0; i < byteLength; i++) {
                data[size++] = 0;
            }
        } else {
            // Input validation
            if (byteOffset < 0 || byteLength < 0 || byteOffset + byteLength > byteArrayValue.length) {
                throw new IndexOutOfBoundsException("Invalid offset or length");
            }
            
            // Copy bytes from input array
            System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
            size += byteLength;
        }
        
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}