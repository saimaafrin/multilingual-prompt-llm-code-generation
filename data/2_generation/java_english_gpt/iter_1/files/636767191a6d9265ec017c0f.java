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
    public void add(byte b) {
        if (currentSize >= data.length) {
            enlarge(1);
        }
        data[currentSize++] = b;
    }

    public int size() {
        return currentSize;
    }

    public byte get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public static void main(String[] args) {
        ByteVector byteVector = new ByteVector(5);
        byteVector.add((byte) 1);
        byteVector.add((byte) 2);
        System.out.println("Size: " + byteVector.size()); // Output: Size: 2
    }
}