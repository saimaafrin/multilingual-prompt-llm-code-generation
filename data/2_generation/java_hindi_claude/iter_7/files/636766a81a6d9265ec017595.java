import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    public ByteVector putTwoBytes(byte byteValue1, byte byteValue2) {
        // Ensure capacity for 2 more bytes
        ensureCapacity(size + 2);
        
        // Add the bytes
        data[size++] = byteValue1;
        data[size++] = byteValue2;
        
        return this;
    }
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
    
    // Helper methods for testing/validation
    public byte[] getData() {
        return Arrays.copyOf(data, size);
    }
    
    public int getSize() {
        return size;
    }
}