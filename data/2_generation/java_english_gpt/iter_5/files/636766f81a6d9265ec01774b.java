import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private int currentByte;
    private boolean endOfStream;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
        this.currentByte = -1;
        this.endOfStream = false;
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

        if (currentByte == -1) {
            currentByte = buffer.read();
            if (currentByte == -1) {
                endOfStream = true;
                throw new IOException("No more data available.");
            }
        }

        byte result = (byte) currentByte;
        currentByte = -1; // Reset for the next read
        return result;
    }
}