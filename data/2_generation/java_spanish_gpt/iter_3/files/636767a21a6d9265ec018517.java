import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BufferToByteArray {
    private ByteArrayOutputStream outputStream;

    public BufferToByteArray() {
        outputStream = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    /** 
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        try {
            BufferToByteArray buffer = new BufferToByteArray();
            buffer.write("Hello, ".getBytes());
            buffer.write("World!".getBytes());
            byte[] result = buffer.toByteArray();
            System.out.println(new String(result)); // Output: Hello, World!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}