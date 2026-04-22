import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;
    private int size;
    
    /**
     * Espande questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            return;
        }
        
        int newCapacity = this.capacity + size;
        byte[] newData = Arrays.copyOf(this.data, newCapacity);
        
        this.data = newData;
        this.capacity = newCapacity;
    }
}