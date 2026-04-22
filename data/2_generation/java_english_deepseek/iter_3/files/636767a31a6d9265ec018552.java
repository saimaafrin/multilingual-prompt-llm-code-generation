import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private final InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Read a {@code string} field value from the stream.
     */
    @Override
    public String readString() throws IOException {
        // Read the length of the string (assuming it's prefixed with its length as an integer)
        int length = readInt();
        if (length < 0) {
            throw new IOException("Invalid string length: " + length);
        }

        // Read the string bytes
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Failed to read the expected number of bytes for the string");
        }

        // Convert bytes to a string using UTF-8 encoding
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private int readInt() throws IOException {
        byte[] bytes = new byte[4];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != 4) {
            throw new IOException("Failed to read an integer from the stream");
        }
        return (bytes[0] << 24) | ((bytes[1] & 0xFF) << 16) | ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
    }
}