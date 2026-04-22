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
        
        int currentCapacity = buffer.length;
        int requiredCapacity = this.size + size;
        
        if (requiredCapacity > currentCapacity) {
            int newCapacity = Math.max(currentCapacity * 2, requiredCapacity);
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }
}