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
     * @param byteOffset index of the first byte of byteArrayValue that must be copied.
     * @param byteLength number of bytes of byteArrayValue that must be copied.
     * @return this byte vector.
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength cannot be negative");
        }
        if (byteArrayValue != null) {
            if (byteOffset < 0 || byteOffset + byteLength > byteArrayValue.length) {
                throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
            }
            ensureCapacity(size + byteLength);
            System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
            size += byteLength;
        } else {
            ensureCapacity(size + byteLength);
            for (int i = 0; i < byteLength; i++) {
                data[size++] = 0; // fill with null bytes
            }
        }
        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            byte[] newData = new byte[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
}