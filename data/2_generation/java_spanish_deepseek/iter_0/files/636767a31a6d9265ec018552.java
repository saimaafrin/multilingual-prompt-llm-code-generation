import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Lee el valor de un campo de tipo {@code string} del flujo.
     */
    @Override
    public String readString() throws IOException {
        int length = readInt(); // Asume que la longitud de la cadena está precedida por un entero
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Failed to read the expected number of bytes for the string.");
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private int readInt() throws IOException {
        byte[] bytes = new byte[4];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != 4) {
            throw new IOException("Failed to read an integer from the stream.");
        }
        return (bytes[0] & 0xFF) << 24 |
               (bytes[1] & 0xFF) << 16 |
               (bytes[2] & 0xFF) << 8  |
               (bytes[3] & 0xFF);
    }
}