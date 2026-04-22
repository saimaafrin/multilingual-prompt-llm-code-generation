import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    public ByteVector putInt(int intValue) {
        int requiredSize = size + 4;
        if (requiredSize > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredSize);
            data = Arrays.copyOf(data, newCapacity);
        }

        // Store int value in big-endian format
        data[size++] = (byte) ((intValue >> 24) & 0xFF);
        data[size++] = (byte) ((intValue >> 16) & 0xFF); 
        data[size++] = (byte) ((intValue >> 8) & 0xFF);
        data[size++] = (byte) (intValue & 0xFF);

        return this;
    }
}