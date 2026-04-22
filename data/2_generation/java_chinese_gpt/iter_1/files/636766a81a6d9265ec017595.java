import java.util.Arrays;

class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    public ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        data[size++] = (byte) byteValue1;
        data[size++] = (byte) byteValue2;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, size);
    }
}