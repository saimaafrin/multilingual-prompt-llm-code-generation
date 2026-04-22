import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialSize) {
        this.data = new byte[initialSize];
        this.currentSize = initialSize;
    }

    /**
     * Aumenta este vector de bytes para que pueda recibir una cantidad adicional de bytes definida por el argumento 'size'. 
     * @param size número de bytes adicionales que este vector de bytes debería poder recibir.
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        int newSize = currentSize + size;
        data = Arrays.copyOf(data, newSize);
        currentSize = newSize;
    }

    // Additional methods for demonstration purposes
    public int getCurrentSize() {
        return currentSize;
    }

    public byte[] getData() {
        return data;
    }
}