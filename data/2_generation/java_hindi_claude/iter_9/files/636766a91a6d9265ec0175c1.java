import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;

    public ByteVector() {
        buffer = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    public void enlarge(final int size) {
        if (size <= 0) {
            return;
        }
        
        int newCapacity = buffer.length;
        int minCapacity = size + this.size;

        // If current capacity is not enough
        if (minCapacity > newCapacity) {
            // Double the capacity until it's large enough
            while (newCapacity < minCapacity) {
                newCapacity = newCapacity * 2;
            }
            
            // Create new array and copy contents
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }
}