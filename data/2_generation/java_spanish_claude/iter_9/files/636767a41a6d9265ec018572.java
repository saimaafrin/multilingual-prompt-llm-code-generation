import java.io.IOException;
import java.io.InputStream;

public class VarintReader {
    private final InputStream input;
    private int position = 0;
    
    public VarintReader(InputStream input) {
        this.input = input;
    }

    /**
     * Lee un Varint crudo del flujo.
     */
    public long readRawVarint64() throws IOException {
        long result = 0;
        int shift = 0;
        while (shift < 64) {
            int b = input.read();
            if (b == -1) {
                throw new IOException("EOF while reading varint");
            }
            position++;
            result |= (long)(b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint");
    }
}