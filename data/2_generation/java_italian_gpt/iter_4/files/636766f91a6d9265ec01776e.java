import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    private final OutputStream outputStream;

    public CustomOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /** 
     * Scrive <code>len</code> byte dall'array di byte specificato, a partire dall'offset <code>off</code>, in questo stream di output di byte.
     * @param b   i dati.
     * @param off l'offset di partenza nei dati.
     * @param len il numero di byte da scrivere.
     */
    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        outputStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}