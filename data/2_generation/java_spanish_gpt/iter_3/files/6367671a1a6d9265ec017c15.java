import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /**
     * Coloca un array de bytes en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param byteArrayValue un array de bytes. Puede ser {@literal null} para colocar {@code byteLength} bytes nulos en este vector de bytes.
     * @param byteOffset índice del primer byte de byteArrayValue que debe ser copiado.
     * @param byteLength número de bytes de byteArrayValue que deben ser copiados.
     * @return este vector de bytes.
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength cannot be negative");
        }
        
        if (byteArrayValue == null) {
            byteArrayValue = new byte[byteLength]; // Create an array of null bytes
        } else if (byteOffset < 0 || byteOffset + byteLength > byteArrayValue.length) {
            throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
        }

        ensureCapacity(size + byteLength);
        System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        size += byteLength;

        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}