import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int size;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
        this.size = 0;
    }

    /**
     * 清空并用提供的字节流填充此 {@code ClassFileBuffer} 的缓冲区。读取指针重置为字节数组的起始位置。
     */
    public void readFrom(final InputStream in) throws IOException {
        // Clear the existing buffer
        this.buffer = new byte[0];
        this.size = 0;

        // Use ByteArrayOutputStream to read from InputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream and write to ByteArrayOutputStream
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            baos.write(tempBuffer, 0, bytesRead);
        }

        // Convert ByteArrayOutputStream to byte array
        this.buffer = baos.toByteArray();
        this.size = this.buffer.length;

        // Reset the read pointer (if applicable, depending on usage context)
        // In this case, we just ensure the buffer is filled with new data.
    }
}