import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
    }

    /** 
     * <code>buffer</code> से एक बाइट पढ़ता है, और आवश्यकतानुसार इसे फिर से भरता है।
     * @return इनपुट स्ट्रीम से अगली बाइट।
     * @throws IOException यदि कोई और डेटा उपलब्ध नहीं है।
     */
    public byte readByte() throws IOException {
        int data = buffer.read();
        if (data == -1) {
            throw new IOException("No more data available");
        }
        return (byte) data;
    }
}