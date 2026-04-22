import java.util.Arrays;

public class ByteVector {
    private byte[] data;

    public ByteVector(int initialSize) {
        data = new byte[initialSize];
    }

    /**
     * Aumenta este vector de bytes para que pueda recibir una cantidad adicional de bytes definida por el argumento 'size'. 
     * @param size número de bytes adicionales que este vector de bytes debería poder recibir.
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        int newSize = data.length + size;
        data = Arrays.copyOf(data, newSize);
    }
}