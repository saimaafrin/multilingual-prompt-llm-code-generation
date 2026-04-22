public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.currentSize = 0;
    }

    /**
     * 扩展此字节向量，以便能够接收 'size' 个额外的字节。
     * @param size 此字节向量应该能够接收的额外字节数。
     */
    private void enlarge(final int size) {
        int requiredSize = currentSize + size;
        if (requiredSize > data.length) {
            int newSize = Math.max(data.length * 2, requiredSize);
            byte[] newData = new byte[newSize];
            System.arraycopy(data, 0, newData, 0, currentSize);
            data = newData;
        }
    }

    // Additional methods to manipulate the byte vector can be added here
}