import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    
    /**
     * Writes <code>b.length</code> bytes from the specified byte array to this output stream.
     * @param b The array of bytes to be written.
     * @exception IOException if an error occurs.
     */
    @Override
    public void write(byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        for (int i = 0; i < b.length; i++) {
            write(b[i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementation of single byte write would go here
        // This is required as OutputStream is abstract
    }
}