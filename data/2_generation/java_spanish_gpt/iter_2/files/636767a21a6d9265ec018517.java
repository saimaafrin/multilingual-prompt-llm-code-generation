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

    /** 
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        try {
            BufferToByteArray bufferToByteArray = new BufferToByteArray();
            bufferToByteArray.write("Hello, ".getBytes());
            bufferToByteArray.write("World!".getBytes());
            byte[] result = bufferToByteArray.toByteArray();
            System.out.println(new String(result)); // Output: Hello, World!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}