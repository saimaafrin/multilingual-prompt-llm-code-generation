import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BufferToByteArray {

    private ByteArrayOutputStream buffer;

    public BufferToByteArray() {
        this.buffer = new ByteArrayOutputStream();
    }

    /**
     * एकल बाइट एरे लौटाता है जिसमें बफर(ों) में लिखी गई सभी सामग्री शामिल होती है।
     *
     * @return बाइट एरे जिसमें बफर की सामग्री होती है
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    // Optional: Method to write data to the buffer
    public void write(byte[] data) throws IOException {
        buffer.write(data);
    }

    // Optional: Method to reset the buffer
    public void reset() {
        buffer.reset();
    }
}