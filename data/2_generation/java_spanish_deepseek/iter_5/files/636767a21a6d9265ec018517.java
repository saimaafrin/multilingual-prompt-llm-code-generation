import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ByteBuffer {

    private ByteArrayOutputStream buffer;

    public ByteBuffer() {
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

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        ByteBuffer byteBuffer = new ByteBuffer();
        byteBuffer.write(new byte[]{1, 2, 3});
        byteBuffer.write(new byte[]{4, 5, 6});

        byte[] result = byteBuffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}