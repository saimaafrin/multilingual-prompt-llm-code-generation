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

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.write("Hello".getBytes());
        buffer.write("World".getBytes());
        byte[] result = buffer.toByteArray();
        System.out.println(new String(result)); // Outputs: HelloWorld
    }
}