import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
    }

    /**
     * 清空并用提供的字节流填充此 {@code ClassFileBuffer} 的缓冲区。读取指针重置为字节数组的起始位置。
     */
    public void readFrom(final InputStream in) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream and write to the ByteArrayOutputStream
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byteArrayOutputStream.write(tempBuffer, 0, bytesRead);
        }

        // Convert the ByteArrayOutputStream to a byte array and set it to the buffer
        this.buffer = byteArrayOutputStream.toByteArray();
    }
}