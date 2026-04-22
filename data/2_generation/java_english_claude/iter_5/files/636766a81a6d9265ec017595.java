import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    
    public ByteVector() {
        data = new byte[64]; // Initial capacity
    }
    
    /**
     * Puts two bytes into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param byteValue1 a byte.
     * @param byteValue2 another byte.
     * @return this byte vector.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (length + 2 > data.length) {
            // Double array size if more space needed
            int newCapacity = Math.max(2 * data.length, length + 2);
            data = Arrays.copyOf(data, newCapacity);
        }
        data[length++] = (byte) byteValue1;
        data[length++] = (byte) byteValue2;
        return this;
    }
}