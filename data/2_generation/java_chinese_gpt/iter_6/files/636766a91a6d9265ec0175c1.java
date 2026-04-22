public class ByteVector {
    private byte[] data;
    private int capacity;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.capacity = 10;
    }

    /**
     * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
     * @param size 此字节向量应该能够接收的额外字节数。
     */
    private void enlarge(final int size) {
        int newCapacity = capacity + size;
        byte[] newData = new byte[newCapacity];
        System.arraycopy(data, 0, newData, 0, capacity);
        data = newData;
        capacity = newCapacity;
    }
}