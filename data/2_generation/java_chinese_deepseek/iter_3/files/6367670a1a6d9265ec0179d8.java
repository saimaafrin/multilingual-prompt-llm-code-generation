import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        // Implement the single byte write method if needed
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
            throw new NullPointerException("Byte array is null");
        }
        // Write the entire byte array to the output stream
        for (byte value : b) {
            write(value);
        }
    }
}