import java.io.IOException;
import java.io.InputStream;

public class VarintReader {
    /**
     * Read a raw Varint from the stream.
     * @param input The input stream to read from
     * @return The decoded varint value
     * @throws IOException If there is an error reading from the stream
     */
    public static long readRawVarint(InputStream input) throws IOException {
        long result = 0;
        int shift = 0;
        int b;
        
        do {
            // Read one byte from stream
            b = input.read();
            if (b == -1) {
                throw new IOException("Reached end of stream while reading varint");
            }
            
            // Add the lower 7 bits to result
            result |= ((long)(b & 0x7F)) << shift;
            shift += 7;
            
            // Continue if most significant bit is 1
        } while ((b & 0x80) != 0);
        
        return result;
    }
}