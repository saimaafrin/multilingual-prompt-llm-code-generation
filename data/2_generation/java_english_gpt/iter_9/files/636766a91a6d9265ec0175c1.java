public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /** 
     * Enlarges this byte vector so that it can receive 'size' more bytes.
     * @param size number of additional bytes that this byte vector should be able to receive.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = currentSize + size;
        byte[] newData = new byte[newSize];
        System.arraycopy(data, 0, newData, 0, currentSize);
        data = newData;
    }

    // Additional methods for demonstration purposes
    public void addBytes(byte[] bytes) {
        if (currentSize + bytes.length > data.length) {
            enlarge(bytes.length);
        }
        System.arraycopy(bytes, 0, data, currentSize, bytes.length);
        currentSize += bytes.length;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public byte[] getData() {
        return data;
    }
}