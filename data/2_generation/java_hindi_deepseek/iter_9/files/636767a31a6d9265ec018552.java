import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private final InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * स्ट्रीम से {@code string} फ़ील्ड मान पढ़ें।
     */
    @Override
    public String readString() throws IOException {
        int length = readInt();
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Unexpected end of stream");
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private int readInt() throws IOException {
        byte[] bytes = new byte[4];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != 4) {
            throw new IOException("Unexpected end of stream");
        }
        return (bytes[0] & 0xFF) << 24 |
               (bytes[1] & 0xFF) << 16 |
               (bytes[2] & 0xFF) << 8  |
               (bytes[3] & 0xFF);
    }
}