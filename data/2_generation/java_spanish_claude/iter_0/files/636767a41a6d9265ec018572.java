import java.io.IOException;
import java.io.InputStream;

public class VarintReader {
    private final InputStream input;
    
    public VarintReader(InputStream input) {
        this.input = input;
    }

    public long readRawVarint64() throws IOException {
        int shift = 0;
        long result = 0;
        while (shift < 64) {
            final int b = input.read();
            if (b == -1) {
                throw new IOException("Premature EOF");
            }
            result |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint");
    }
}