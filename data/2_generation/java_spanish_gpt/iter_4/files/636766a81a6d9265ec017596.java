import java.util.Arrays;

public class ByteVector {
    private byte[] bytes;
    private int size;

    public ByteVector() {
        this.bytes = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /**
     * Inserta un entero en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param intValue un entero.
     * @return este vector de bytes.
     */
    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + Integer.BYTES);
        for (int i = 0; i < Integer.BYTES; i++) {
            bytes[size++] = (byte) (intValue >> (i * 8));
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > bytes.length) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(bytes, size);
    }
}