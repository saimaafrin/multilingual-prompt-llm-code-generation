import java.util.Arrays;

public class ByteArrayBuffer {
    private byte[] buffer;
    private int size;
    private static final int DEFAULT_CAPACITY = 32;

    public ByteArrayBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public ByteArrayBuffer(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must not be negative");
        }
        this.buffer = new byte[capacity];
    }

    public void append(byte[] b, int off, int len) {
        if (b == null) {
            return;
        }
        if ((off < 0) || (off > b.length) || (len < 0) ||
                ((off + len) < 0) || ((off + len) > b.length)) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        int newsize = this.size + len;
        if (newsize > this.buffer.length) {
            expand(newsize);
        }
        System.arraycopy(b, off, this.buffer, this.size, len);
        this.size = newsize;
    }

    private void expand(int newsize) {
        byte[] newbuffer = new byte[Math.max(this.buffer.length << 1, newsize)];
        System.arraycopy(this.buffer, 0, newbuffer, 0, this.size);
        this.buffer = newbuffer;
    }

    /**
     * 返回一个包含所有写入缓冲区内容的单字节数组。
     */
    public final byte[] toByteArray() {
        return Arrays.copyOf(buffer, size);
    }
}