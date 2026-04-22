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

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        BufferToByteArray buffer = new BufferToByteArray();
        try {
            buffer.write("Hello, World!".getBytes());
            byte[] byteArray = buffer.toByteArray();
            System.out.println(new String(byteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}