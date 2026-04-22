import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private byte[] buffer;
    private int count;

    public ByteArrayOutputStream() {
        this(32);
    }

    public ByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        buffer = new byte[size];
    }

    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if ((off < 0) || (off > b.length) || (len < 0) ||
            ((off + len) - b.length > 0)) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(count + len);
        System.arraycopy(b, off, buffer, count, len);
        count += len;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - buffer.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = buffer.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity < 0) {
            if (minCapacity < 0) {
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        byte[] newBuffer = new byte[newCapacity];
        System.arraycopy(buffer, 0, newBuffer, 0, count);
        buffer = newBuffer;
    }

    @Override
    public void write(int b) throws IOException {
        ensureCapacity(count + 1);
        buffer[count] = (byte) b;
        count++;
    }

    public byte[] toByteArray() {
        return java.util.Arrays.copyOf(buffer, count);
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        return new String(buffer, 0, count);
    }
}