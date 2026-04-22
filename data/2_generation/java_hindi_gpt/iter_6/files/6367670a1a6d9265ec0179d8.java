import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Implement the logic to write the byte array to the output stream
        for (byte value : b) {
            write(value); // Call the single byte write method
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the logic to write a single byte
        // This is just a placeholder implementation
        System.out.write(b);
    }
}