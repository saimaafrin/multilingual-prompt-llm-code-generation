import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Default initial capacity
    }
    
    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
    }
    
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (length + 2 > data.length) {
            // Need to expand array
            int newCapacity = Math.max(2 * data.length, length + 2);
            data = Arrays.copyOf(data, newCapacity);
        }
        
        // Add the two bytes
        data[length++] = (byte) byteValue1;
        data[length++] = (byte) byteValue2;
        
        return this;
    }
}