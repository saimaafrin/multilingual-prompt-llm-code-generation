import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;
    
    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
    }
    
    public ByteVector putInt(final int intValue) {
        int requiredSize = size + 4;
        if (requiredSize > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredSize);
            data = Arrays.copyOf(data, newCapacity);
        }
        
        // Store integer in big-endian format
        data[size++] = (byte)(intValue >>> 24);
        data[size++] = (byte)(intValue >>> 16);
        data[size++] = (byte)(intValue >>> 8);
        data[size++] = (byte)intValue;
        
        return this;
    }
    
    // Helper methods
    public byte[] getData() {
        return Arrays.copyOf(data, size);
    }
    
    public int getSize() {
        return size;
    }
}