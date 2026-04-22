import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private byte[] buffer;
    private int position;
    private int count;
    private InputStream input;
    private static final int BUFFER_SIZE = 8192;

    public ByteReader(InputStream in) {
        this.input = in;
        this.buffer = new byte[BUFFER_SIZE];
        this.position = 0;
        this.count = 0;
    }

    public byte readByte() throws IOException {
        if (position >= count) {
            count = input.read(buffer);
            if (count == -1) {
                throw new IOException("End of stream reached");
            }
            position = 0;
        }
        return buffer[position++];
    }
}