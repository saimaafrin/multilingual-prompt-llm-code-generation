import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    private void enlarge(final int size) {
        int newLength = length + size;
        if (newLength > data.length) {
            // Calculate new array size - double current size or add size needed, whichever is larger
            int newArraySize = Math.max(data.length * 2, newLength);
            // Create new array and copy existing data
            data = Arrays.copyOf(data, newArraySize);
        }
    }
}