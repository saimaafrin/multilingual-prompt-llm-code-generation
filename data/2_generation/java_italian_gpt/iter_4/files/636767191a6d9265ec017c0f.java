import java.util.Arrays;

public class ByteArrayEnlarger {
    private byte[] byteArray;

    public ByteArrayEnlarger(int initialSize) {
        byteArray = new byte[initialSize];
    }

    /**
     * Aumenta la taglia di questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        int currentLength = byteArray.length;
        int newLength = currentLength + size;
        byteArray = Arrays.copyOf(byteArray, newLength);
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public static void main(String[] args) {
        ByteArrayEnlarger enlarger = new ByteArrayEnlarger(5);
        System.out.println("Initial length: " + enlarger.getByteArray().length);
        enlarger.enlarge(10);
        System.out.println("New length after enlargement: " + enlarger.getByteArray().length);
    }
}