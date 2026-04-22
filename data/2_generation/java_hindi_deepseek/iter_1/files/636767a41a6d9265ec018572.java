import java.io.IOException;
import java.io.InputStream;

public class VarintReader {

    private final InputStream inputStream;

    public VarintReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * स्ट्रीम से एक कच्चा Varint पढ़ें।
     */
    public long readRawVarint64() throws IOException {
        long result = 0;
        int shift = 0;
        while (shift < 64) {
            int b = inputStream.read();
            if (b == -1) {
                throw new IOException("Unexpected end of stream while reading varint");
            }
            result |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint64");
    }
}