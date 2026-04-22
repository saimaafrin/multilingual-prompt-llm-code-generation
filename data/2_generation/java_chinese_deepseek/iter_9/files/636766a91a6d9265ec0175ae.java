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
            ensureCapacity(size + byteLength);
            Arrays.fill(buffer, size, size + byteLength, (byte) 0);
            size += byteLength;
        } else {
            if (byteOffset < 0 || byteLength < 0 || byteOffset + byteLength > byteArrayValue.length) {
                throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
            }
            ensureCapacity(size + byteLength);
            System.arraycopy(byteArrayValue, byteOffset, buffer, size, byteLength);
            size += byteLength;
        }
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            int newCapacity = buffer.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(buffer, size);
    }
}