import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // initial capacity
        this.size = 0;
    }

    /** 
     * Puts an array of bytes into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param byteArrayValue an array of bytes. May be {@literal null} to put {@code byteLength} nullbytes into this byte vector.
     * @param byteOffset     index of the first byte of byteArrayValue that must be copied.
     * @param byteLength     number of bytes of byteArrayValue that must be copied.
     * @return this byte vector.
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteArrayValue == null) {
            ensureCapacity(size + byteLength);
            Arrays.fill(data, size, size + byteLength, (byte) 0);
            size += byteLength;
        } else {
            if (byteOffset < 0 || byteLength < 0 || byteOffset + byteLength > byteArrayValue.length) {
                throw new IndexOutOfBoundsException("Invalid offset or length");
            }
            ensureCapacity(size + byteLength);
            System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
            size += byteLength;
        }
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