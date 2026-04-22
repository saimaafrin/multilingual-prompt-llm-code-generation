import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int length;
    private static final int DEFAULT_CAPACITY = 64;
    
    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        length = 0;
    }
    
    /**
     * Coloca dos bytes en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param byteValue1 un byte.
     * @param byteValue2 otro byte.
     * @return este vector de bytes.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (length + 2 > data.length) {
            // Expand array if needed
            data = Arrays.copyOf(data, Math.max(2 * data.length, length + 2));
        }
        
        // Add the two bytes
        data[length++] = (byte) byteValue1;
        data[length++] = (byte) byteValue2;
        
        return this;
    }
}