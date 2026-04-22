import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Implementation of writing the byte array to the output stream
        for (byte value : b) {
            write(value); // Call the single byte write method
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementation for writing a single byte
        // This is just a placeholder; actual implementation will depend on the specific output stream behavior
        System.out.write(b);
    }
}