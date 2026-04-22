public class ByteArrayEnlarger {
    
    private byte[] byteArray;

    public ByteArrayEnlarger(int initialSize) {
        this.byteArray = new byte[initialSize];
    }

    /**
     * Aumenta la taglia di questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        int currentLength = byteArray.length;
        int newLength = currentLength + size;
        byte[] newArray = new byte[newLength];
        System.arraycopy(byteArray, 0, newArray, 0, currentLength);
        byteArray = newArray;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public static void main(String[] args) {
        ByteArrayEnlarger enlarger = new ByteArrayEnlarger(10);
        System.out.println("Initial length: " + enlarger.getByteArray().length);
        enlarger.enlarge(5);
        System.out.println("New length after enlargement: " + enlarger.getByteArray().length);
    }
}