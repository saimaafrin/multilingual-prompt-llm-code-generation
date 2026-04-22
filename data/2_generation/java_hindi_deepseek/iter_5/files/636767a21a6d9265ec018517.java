import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BufferToByteArray {

    private ByteArrayOutputStream buffer;

    public BufferToByteArray() {
        this.buffer = new ByteArrayOutputStream();
    }

    /**
     * एकल बाइट एरे लौटाता है जिसमें बफर(ों) में लिखी गई सभी सामग्री शामिल होती है।
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    // Example usage
    public static void main(String[] args) {
        BufferToByteArray buffer = new BufferToByteArray();
        try {
            buffer.buffer.write("Hello, World!".getBytes());
            byte[] byteArray = buffer.toByteArray();
            System.out.println(new String(byteArray)); // Output: Hello, World!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}