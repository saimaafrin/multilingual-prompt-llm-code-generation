import java.io.IOException;
import java.io.InputStream;

public class VarintReader {
    private InputStream input;

    public VarintReader(InputStream input) {
        this.input = input;
    }

    /** 
     * Lee un Varint crudo del flujo.
     */
    public long readRawVarint64() throws IOException {
        long result = 0;
        int shift = 0;
        int byteRead;

        while (true) {
            byteRead = input.read();
            if (byteRead == -1) {
                throw new IOException("End of stream reached before Varint was fully read.");
            }
            result |= (long)(byteRead & 0x7F) << shift;
            if ((byteRead & 0x80) == 0) {
                break;
            }
            shift += 7;
            if (shift >= 64) {
                throw new IOException("Varint is too long.");
            }
        }
        return result;
    }
}