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
        ensureCapacity(size + INT_SIZE);
        
        // Store int value in big-endian format
        bytes[size] = (byte) ((intValue >> 24) & 0xFF);
        bytes[size + 1] = (byte) ((intValue >> 16) & 0xFF); 
        bytes[size + 2] = (byte) ((intValue >> 8) & 0xFF);
        bytes[size + 3] = (byte) (intValue & 0xFF);
        
        size += INT_SIZE;
        return this;
    }
    
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > bytes.length) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }
}