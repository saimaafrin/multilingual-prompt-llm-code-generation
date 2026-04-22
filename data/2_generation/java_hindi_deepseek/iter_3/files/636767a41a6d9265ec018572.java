import java.io.IOException;
import java.io.InputStream;

public class VarintReader {

    /**
     * स्ट्रीम से एक कच्चा Varint पढ़ें।
     * @return पढ़ा गया Varint मान
     * @throws IOException यदि इनपुट स्ट्रीम से पढ़ने में कोई त्रुटि होती है
     */
    public long readRawVarint64(InputStream input) throws IOException {
        long result = 0;
        int shift = 0;
        while (shift < 64) {
            int b = input.read();
            if (b == -1) {
                throw new IOException("Unexpected end of stream while reading varint");
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