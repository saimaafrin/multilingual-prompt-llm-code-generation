import java.io.IOException;
import java.io.InputStream;

public class BufferedReader {
    private static final int BUFFER_SIZE = 8192;
    private byte[] buffer;
    private int pos;
    private int count;
    private InputStream in;

    public int read() throws IOException {
        if (pos >= count) {
            // Buffer is empty, try to refill
            count = in.read(buffer, 0, BUFFER_SIZE);
            if (count < 0) {
                // No more data available
                throw new IOException("End of stream reached");
            }
            pos = 0;
        }
        return buffer[pos++] & 0xff;
    }
}