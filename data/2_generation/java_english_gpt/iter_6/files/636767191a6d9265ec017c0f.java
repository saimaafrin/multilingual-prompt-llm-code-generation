import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /** 
     * Enlarges this byte vector so that it can receive 'size' more bytes.
     * @param size number of additional bytes that this byte vector should be able to receive.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = currentSize + size;
        if (newSize > data.length) {
            data = Arrays.copyOf(data, newSize);
        }
    }

    // Additional methods for demonstration purposes
    public void addBytes(byte[] bytes) {
        enlarge(bytes.length);
        System.arraycopy(bytes, 0, data, currentSize, bytes.length);
        currentSize += bytes.length;
    }

    public byte[] getData() {
        return Arrays.copyOf(data, currentSize);
    }

    public static void main(String[] args) {
        ByteVector byteVector = new ByteVector(5);
        byteVector.addBytes(new byte[]{1, 2, 3});
        System.out.println(Arrays.toString(byteVector.getData())); // Output: [1, 2, 3]
    }
}