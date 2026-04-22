import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;

    public ByteVector() {
        buffer = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    public void enlarge(int size) {
        if (size <= 0) {
            return;
        }
        
        int minCapacity = this.size + size;
        if (minCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length * 2, minCapacity);
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }
}