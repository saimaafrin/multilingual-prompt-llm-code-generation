import java.io.IOException;
import java.io.InputStream;

public class VarintReader {
    private final InputStream input;
    private int position;
    
    public VarintReader(InputStream input) {
        this.input = input;
        this.position = 0;
    }

    public long readRawVarint64() throws IOException {
        long result = 0;
        int shift = 0;
        while (shift < 64) {
            int b = input.read();
            if (b == -1) {
                throw new IOException("Malformed varint - reached end of stream");
            }
            position++;
            result |= (long)(b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint - too many bytes");
    }
}