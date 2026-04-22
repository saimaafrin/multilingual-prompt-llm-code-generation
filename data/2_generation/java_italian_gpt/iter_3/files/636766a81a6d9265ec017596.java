import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * Inserisce un intero in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param intValue un intero.
     * @return questo vettore di byte.
     */
    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + Integer.BYTES);
        for (int i = 0; i < Integer.BYTES; i++) {
            data[size++] = (byte) (intValue >> (i * 8));
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}