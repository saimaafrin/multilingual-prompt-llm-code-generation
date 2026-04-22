import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    private final OutputStream out;

    public CustomOutputStream(OutputStream out) {
        this.out = out;
    }

    /**
     * Writes the specified byte array to this output stream.
     * 
     * @param b the data to be written.
     * @throws IOException if an I/O error occurs.
     * @see OutputStream#write(byte[])
     */
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}