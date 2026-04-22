public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * 将一个字节数组放入此字节向量中。如果有必要，字节向量会自动扩展。
     * @param byteArrayValue 字节数组。可以为 {@literal null}，以将 {@code byteLength} 个空字节放入此字节向量中。
     * @param byteOffset 要复制的 byteArrayValue 的第一个字节的索引。
     * @param byteLength 要复制的 byteArrayValue 的字节数。
     * @return 此字节向量。
     */
    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteArrayValue == null) {
            ensureCapacity(size + byteLength);
            for (int i = 0; i < byteLength; i++) {
                data[size++] = 0; // Fill with empty bytes
            }
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

    private void ensureCapacity(int newSize) {
        if (newSize > data.length) {
            int newCapacity = Math.max(data.length * 2, newSize);
            byte[] newData = new byte[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public int size() {
        return size;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}