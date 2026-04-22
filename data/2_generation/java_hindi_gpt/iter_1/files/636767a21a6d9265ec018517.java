import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {
    private final ByteArrayOutputStream outputStream;

    public Buffer() {
        this.outputStream = new ByteArrayOutputStream();
    }

    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    /**
     * एकल बाइट एरे लौटाता है जिसमें बफर(ों) में लिखी गई सभी सामग्री शामिल होती है।
     */
    public final byte[] toByteArray() {
        return outputStream.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write("Hello, World!".getBytes());
        byte[] byteArray = buffer.toByteArray();
        System.out.println(new String(byteArray));
    }
}