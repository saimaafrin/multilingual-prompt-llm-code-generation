import java.util.Arrays;

public class ByteVector {
    private byte[] bytes;
    private int size;

    public ByteVector() {
        this.bytes = new byte[0];
        this.size = 0;
    }

    /**
     * Inserisce due byte in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param byteValue1 un byte.
     * @param byteValue2 un altro byte.
     * @return questo vettore di byte.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        if (size + 2 > bytes.length) {
            bytes = Arrays.copyOf(bytes, Math.max(size + 2, bytes.length * 2));
        }
        bytes[size++] = (byte) byteValue1;
        bytes[size++] = (byte) byteValue2;
        return this;
    }

    public byte[] getBytes() {
        return Arrays.copyOf(bytes, size);
    }
}