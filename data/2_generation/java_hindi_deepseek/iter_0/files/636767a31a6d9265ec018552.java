import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    /**
     * स्ट्रीम से {@code string} फ़ील्ड मान पढ़ें।
     */
    @Override
    public String readString() throws IOException {
        InputStream inputStream = getInputStream(); // Assume this method provides the input stream
        byte[] lengthBytes = new byte[4];
        inputStream.read(lengthBytes);
        int length = (lengthBytes[0] & 0xFF) << 24 |
                     (lengthBytes[1] & 0xFF) << 16 |
                     (lengthBytes[2] & 0xFF) << 8 |
                     (lengthBytes[3] & 0xFF);
        byte[] stringBytes = new byte[length];
        inputStream.read(stringBytes);
        return new String(stringBytes, StandardCharsets.UTF_8);
    }

    // Dummy method to simulate getting an input stream
    private InputStream getInputStream() {
        // This should be replaced with actual logic to get the input stream
        return null;
    }
}