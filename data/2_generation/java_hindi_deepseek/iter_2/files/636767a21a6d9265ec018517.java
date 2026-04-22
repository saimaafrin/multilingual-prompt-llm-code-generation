import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BufferToByteArray {

    private ByteArrayOutputStream buffer;

    public BufferToByteArray() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        buffer.write(data);
    }

    public byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        BufferToByteArray buffer = new BufferToByteArray();
        buffer.write("Hello, World!".getBytes());
        byte[] result = buffer.toByteArray();
        System.out.println(new String(result));
    }
}