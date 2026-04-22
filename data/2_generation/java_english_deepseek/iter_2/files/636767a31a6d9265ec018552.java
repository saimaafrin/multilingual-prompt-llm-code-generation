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
     *
     * @return the string read from the stream
     * @throws IOException if an I/O error occurs
     */
    @Override
    public String readString() throws IOException {
        // Read the length of the string (assuming it's prefixed by its length as an integer)
        int length = readInt();
        if (length < 0) {
            throw new IOException("Invalid string length: " + length);
        }

        // Read the string bytes
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Failed to read the expected number of bytes");
        }

        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private int readInt() throws IOException {
        byte[] buffer = new byte[4];
        int bytesRead = inputStream.read(buffer);
        if (bytesRead != 4) {
            throw new IOException("Failed to read an integer from the stream");
        }
        return (buffer[0] << 24) | ((buffer[1] & 0xFF) << 16) | ((buffer[2] & 0xFF) << 8) | (buffer[3] & 0xFF);
    }
}