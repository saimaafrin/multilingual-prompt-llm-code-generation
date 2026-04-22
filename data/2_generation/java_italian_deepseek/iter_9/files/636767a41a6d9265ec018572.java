import java.io.IOException;
import java.io.InputStream;

public class VarintReader {

    public long readRawVarint64(InputStream input) throws IOException {
        long result = 0;
        int shift = 0;
        while (shift < 64) {
            final byte b = (byte) input.read();
            result |= (long) (b & 0x7F) << shift;
            if ((b & 0x80) == 0) {
                return result;
            }
            shift += 7;
        }
        throw new IOException("Malformed varint64");
    }
}