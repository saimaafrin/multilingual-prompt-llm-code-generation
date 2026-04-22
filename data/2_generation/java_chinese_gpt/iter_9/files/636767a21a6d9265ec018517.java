import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    /**
     * 返回一个包含所有写入缓冲区内容的单字节数组。
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public void write(byte[] data) throws IOException {
        buffer.write(data);
    }

    public void close() throws IOException {
        buffer.close();
    }
}