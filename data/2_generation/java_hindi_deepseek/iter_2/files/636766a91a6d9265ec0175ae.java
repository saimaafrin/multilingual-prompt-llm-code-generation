import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int size;

    public ByteVector() {
        this.buffer = new byte[16]; // Initial capacity
        this.size = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteArrayValue == null) {
            throw new IllegalArgumentException("byteArrayValue cannot be null");
        }
        if (byteOffset < 0 || byteLength < 0 || byteOffset + byteLength > byteArrayValue.length) {
            throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
        }

        ensureCapacity(size + byteLength);

        System.arraycopy(byteArrayValue, byteOffset, buffer, size, byteLength);
        size += byteLength;

        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length * 2, requiredCapacity);
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(buffer, size);
    }

    public int size() {
        return size;
    }
}