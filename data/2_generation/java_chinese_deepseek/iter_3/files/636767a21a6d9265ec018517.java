import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        try {
            buffer.write(data);
        } catch (IOException e) {
            // Handle the exception, though ByteArrayOutputStream.write() does not throw IOException
            e.printStackTrace();
        }
    }

    /**
     * 返回一个包含所有写入缓冲区内容的单字节数组。
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.write(new byte[]{1, 2, 3, 4, 5});
        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}