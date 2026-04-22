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

    // Example method to write data to the buffer
    public void writeToBuffer(byte[] data) throws IOException {
        buffer.write(data);
    }

    // Example usage
    public static void main(String[] args) throws IOException {
        BufferToByteArray buffer = new BufferToByteArray();
        buffer.writeToBuffer(new byte[]{1, 2, 3, 4, 5});
        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}