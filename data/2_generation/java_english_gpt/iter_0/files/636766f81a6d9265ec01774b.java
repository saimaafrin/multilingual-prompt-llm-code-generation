import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private int currentByte;
    private boolean endOfStream = false;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
    }

    /** 
     * Reads a byte from the <code>buffer</code>, and refills it as necessary.
     * @return The next byte from the input stream.
     * @throws IOException if there is no more data available.
     */
    public byte readByte() throws IOException {
        if (endOfStream) {
            throw new IOException("No more data available.");
        }

        currentByte = buffer.read();
        if (currentByte == -1) {
            endOfStream = true;
            throw new IOException("No more data available.");
        }
        return (byte) currentByte;
    }
}