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
        byte[] newByteArray = new byte[currentSize + size];
        System.arraycopy(byteArray, 0, newByteArray, 0, currentSize);
        byteArray = newByteArray;
        currentSize += size;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public static void main(String[] args) {
        ByteVectorEnlarger vector = new ByteVectorEnlarger(10);
        System.out.println("Current size: " + vector.getCurrentSize());
        vector.enlarge(5);
        System.out.println("New size: " + vector.getCurrentSize());
    }
}