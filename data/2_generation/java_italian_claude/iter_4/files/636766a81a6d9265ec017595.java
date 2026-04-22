import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ByteVector() {
        data = new byte[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Inserisce due byte in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param byteValue1 un byte.
     * @param byteValue2 un altro byte.
     * @return questo vettore di byte.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (size + 2 > data.length) {
            // Double array size if more space needed
            data = Arrays.copyOf(data, data.length * 2);
        }
        
        data[size++] = (byte) byteValue1;
        data[size++] = (byte) byteValue2;
        
        return this;
    }
}