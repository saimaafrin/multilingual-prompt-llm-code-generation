import java.util.Arrays;

public class ByteVector {
    private byte[] bytes;
    private int size;

    public ByteVector() {
        this.bytes = new byte[2]; // inizializza con una dimensione iniziale
        this.size = 0;
    }

    /**
     * Inserisce due byte in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param byteValue1 un byte.
     * @param byteValue2 un altro byte.
     * @return questo vettore di byte.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        bytes[size++] = (byte) byteValue1;
        bytes[size++] = (byte) byteValue2;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - bytes.length > 0) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }

    public byte[] toArray() {
        return Arrays.copyOf(bytes, size);
    }
}