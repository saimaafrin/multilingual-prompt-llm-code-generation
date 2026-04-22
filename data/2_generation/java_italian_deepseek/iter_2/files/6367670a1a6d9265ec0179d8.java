import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        // Implement single byte write logic here
    }

    /** 
     * @see OutputStream#write(byte[]) 
     */
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        for (byte value : b) {
            write(value);
        }
    }
}