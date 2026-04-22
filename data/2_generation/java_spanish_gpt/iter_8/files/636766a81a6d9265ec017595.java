import java.util.Arrays;

class ByteVector {
    private byte[] bytes;
    private int size;

    public ByteVector() {
        this.bytes = new byte[2]; // Initial capacity
        this.size = 0;
    }

    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        bytes[size++] = (byte) byteValue1;
        bytes[size++] = (byte) byteValue2;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - bytes.length > 0) {
            int newCapacity = Math.max(bytes.length * 2, minCapacity);
            bytes = Arrays.copyOf(bytes, newCapacity);
        }
    }

    public byte[] getBytes() {
        return Arrays.copyOf(bytes, size);
    }
}