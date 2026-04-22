import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream outputStream;

    public Buffer() {
        outputStream = new ByteArrayOutputStream();
    }

    /**
     * 返回一个包含所有写入缓冲区内容的单字节数组。
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }

    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    public void close() throws IOException {
        outputStream.close();
    }
}