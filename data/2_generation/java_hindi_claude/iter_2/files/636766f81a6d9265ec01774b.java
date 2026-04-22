import java.io.IOException;
import java.io.InputStream;

public class BufferedReader {
    private byte[] buffer;
    private int pos;
    private int count;
    private InputStream in;
    private static final int BUFFER_SIZE = 8192;

    public int read() throws IOException {
        if (pos >= count) {
            // Buffer is empty, try to refill
            count = in.read(buffer, 0, buffer.length);
            if (count == -1) {
                // No more data
                throw new IOException("End of stream reached");
            }
            pos = 0;
        }
        return buffer[pos++] & 0xff;
    }

    public BufferedReader(InputStream in) {
        this.in = in;
        this.buffer = new byte[BUFFER_SIZE];
        this.pos = 0;
        this.count = 0;
    }
}