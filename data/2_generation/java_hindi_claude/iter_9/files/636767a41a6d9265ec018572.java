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
        long value = 0;
        int shift = 0;
        int b;
        
        do {
            // Read one byte from stream
            b = input.read();
            if (b == -1) {
                throw new IOException("Reached end of stream while reading varint");
            }
            
            // Add the lower 7 bits to the result
            value |= ((long)(b & 0x7F)) << shift;
            shift += 7;
            
            // Continue if the high bit is set
        } while ((b & 0x80) != 0);
        
        return value;
    }
}