public class ByteVectorEnlarger {
    private byte[] byteArray;
    private int currentSize;

    public ByteVectorEnlarger(int initialSize) {
        this.byteArray = new byte[initialSize];
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
        byte[] newByteArray = new byte[newSize];
        System.arraycopy(byteArray, 0, newByteArray, 0, currentSize);
        byteArray = newByteArray;
        currentSize = newSize;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public static void main(String[] args) {
        ByteVectorEnlarger vector = new ByteVectorEnlarger(5);
        vector.enlarge(10);
        System.out.println("New size of byte array: " + vector.getByteArray().length);
    }
}