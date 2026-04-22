import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream inputStream;
    private byte[] buffer;
    private int bufferPosition;
    private int bufferLength;

    public ByteReader(InputStream inputStream) {
        this.inputStream = inputStream;
        this.buffer = new byte[8192]; // 8KB buffer
        this.bufferPosition = 0;
        this.bufferLength = 0;
    }

    /**
     * <code>buffer</code> से एक बाइट पढ़ता है, और आवश्यकतानुसार इसे फिर से भरता है।
     * @return इनपुट स्ट्रीम से अगली बाइट।
     * @throws IOException यदि कोई और डेटा उपलब्ध नहीं है।
     */
    public byte readByte() throws IOException {
        if (bufferPosition >= bufferLength) {
            refillBuffer();
        }
        if (bufferLength == -1) {
            throw new IOException("No more data available");
        }
        return buffer[bufferPosition++];
    }

    private void refillBuffer() throws IOException {
        bufferLength = inputStream.read(buffer);
        bufferPosition = 0;
    }
}