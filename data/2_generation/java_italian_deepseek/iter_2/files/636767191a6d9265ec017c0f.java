import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
    }

    /**
     * Aumenta la taglia di questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        int newCapacity = capacity + size;
        byte[] newData = Arrays.copyOf(data, newCapacity);
        data = newData;
        capacity = newCapacity;
    }

    // Example usage
    public static void main(String[] args) {
        ByteVector vector = new ByteVector(10);
        vector.enlarge(5);
        System.out.println("New capacity: " + vector.capacity);
    }
}