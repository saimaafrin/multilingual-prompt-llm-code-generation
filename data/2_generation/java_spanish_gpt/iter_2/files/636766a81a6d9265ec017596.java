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
        ensureCapacity(size + 4); // 4 bytes for an integer
        bytes[size++] = (byte) (intValue >> 24);
        bytes[size++] = (byte) (intValue >> 16);
        bytes[size++] = (byte) (intValue >> 8);
        bytes[size++] = (byte) intValue;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - bytes.length > 0) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(bytes, size);
    }
}