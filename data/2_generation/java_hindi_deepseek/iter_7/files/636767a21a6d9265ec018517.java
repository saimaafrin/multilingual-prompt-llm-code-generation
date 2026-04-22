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
     * एकल बाइट एरे लौटाता है जिसमें बफर(ों) में लिखी गई सभी सामग्री शामिल होती है।
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        BufferToByteArray buffer = new BufferToByteArray();
        buffer.write(new byte[]{1, 2, 3});
        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}