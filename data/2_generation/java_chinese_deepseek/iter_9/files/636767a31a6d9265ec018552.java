import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private final InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 从流中读取 {@code string} 字段值。
     */
    @Override
    public String readString() throws IOException {
        int length = inputStream.read();
        if (length == -1) {
            throw new IOException("End of stream reached");
        }
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Expected " + length + " bytes, but only read " + bytesRead);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}