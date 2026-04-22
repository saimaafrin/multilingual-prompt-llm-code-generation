import java.io.IOException;

public class ByteReader {
    private byte[] buffer;
    private int pos;
    private int count;
    private InputStream in;
    
    public ByteReader(InputStream in) {
        this.in = in;
        this.buffer = new byte[8192];
        this.pos = 0;
        this.count = 0;
    }

    /**
     * Reads a byte from the <code>buffer</code>, and refills it as necessary.
     * @return The next byte from the input stream.
     * @throws IOException if there is no more data available.
     */
    public byte readByte() throws IOException {
        if (pos >= count) {
            count = in.read(buffer);
            if (count == -1) {
                throw new IOException("End of stream reached");
            }
            pos = 0;
        }
        return buffer[pos++];
    }
}