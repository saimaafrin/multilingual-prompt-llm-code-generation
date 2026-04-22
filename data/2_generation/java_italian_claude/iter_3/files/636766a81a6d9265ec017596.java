import java.util.Arrays;

public class ByteVector {
    private byte[] bytes;
    private int size;
    private static final int INT_SIZE = 4;
    
    public ByteVector() {
        bytes = new byte[10];
        size = 0;
    }
    
    public ByteVector putInt(final int intValue) {
        // Ensure capacity
        ensureCapacity(size + INT_SIZE);
        
        // Convert int to bytes and add to array
        bytes[size] = (byte)(intValue >> 24);
        bytes[size + 1] = (byte)(intValue >> 16);
        bytes[size + 2] = (byte)(intValue >> 8);
        bytes[size + 3] = (byte)intValue;
        
        size += INT_SIZE;
        
        return this;
    }
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > bytes.length) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }
    
    // Helper methods for getting array and size
    public byte[] getBytes() {
        return Arrays.copyOf(bytes, size);
    }
    
    public int size() {
        return size;
    }
}