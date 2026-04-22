import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream inputStream;
    private byte[] buffer;
    private int bufferPosition;
    private int bufferLength;

    public ByteReader(InputStream inputStream, int bufferSize) {
        this.inputStream = inputStream;
        this.buffer = new byte[bufferSize];
        this.bufferPosition = 0;
        this.bufferLength = 0;
    }

    /**
     * Reads a byte from the <code>buffer</code>, and refills it as necessary.
     * @return The next byte from the input stream.
     * @throws IOException if there is no more data available.
     */
    public byte readByte() throws IOException {
        if (bufferPosition >= bufferLength) {
            refillBuffer();
        }
        return buffer[bufferPosition++];
    }

    private void refillBuffer() throws IOException {
        bufferLength = inputStream.read(buffer);
        if (bufferLength == -1) {
            throw new IOException("No more data available");
        }
        bufferPosition = 0;
    }
}