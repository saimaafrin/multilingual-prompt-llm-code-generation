import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;
    private int size;
    
    private void enlarge(final int size) {
        // Calculate new capacity needed
        int newCapacity = this.capacity + size;
        
        // Create new array with increased size
        byte[] newData = Arrays.copyOf(this.data, newCapacity);
        
        // Update instance variables
        this.data = newData;
        this.capacity = newCapacity;
    }
}