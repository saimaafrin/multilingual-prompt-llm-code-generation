import java.io.IOException;
import java.io.InputStream;

public class CustomInputStream extends InputStream {
    private InputStream inputStream;

    public CustomInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Returns an estimate of the number of bytes that can be read (or skipped over) from this input stream
     * without blocking by the next invocation of a method for this input stream.
     *
     * @return an estimate of the number of bytes that can be read (or skipped over) from this input stream
     *         without blocking.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}