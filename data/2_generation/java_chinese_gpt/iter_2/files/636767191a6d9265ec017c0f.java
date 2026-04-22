public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /**
     * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
     * @param size 此字节向量应该能够接收的额外字节数。
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = currentSize + size;
        if (newSize > data.length) {
            int newCapacity = Math.max(data.length * 2, newSize);
            byte[] newData = new byte[newCapacity];
            System.arraycopy(data, 0, newData, 0, currentSize);
            data = newData;
        }
    }
}