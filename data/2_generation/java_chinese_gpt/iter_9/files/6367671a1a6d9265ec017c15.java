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
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength cannot be negative");
        }
        
        if (byteArrayValue == null) {
            byteArrayValue = new byte[byteLength]; // Create an array of empty bytes
        } else if (byteOffset < 0 || byteOffset + byteLength > byteArrayValue.length) {
            throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
        }

        ensureCapacity(size + byteLength);
        
        if (byteArrayValue != null) {
            System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        }
        
        size += byteLength;
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

    public int size() {
        return size;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}