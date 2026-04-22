import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * 将一个字节数组放入此字节向量中。如有必要，字节向量会自动扩展。
     * @param byteArrayValue 字节数组。如果为 {@literal null}，则在字节向量中添加 {@code byteLength} 个空字节。
     * @param byteOffset     要复制的 byteArrayValue 的第一个字节的索引。
     * @param byteLength     要复制的 byteArrayValue 的字节数。
     * @return 此字节向量。
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

    private void ensureCapacity(int newSize) {
        if (newSize > data.length) {
            int newCapacity = Math.max(data.length * 2, newSize);
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