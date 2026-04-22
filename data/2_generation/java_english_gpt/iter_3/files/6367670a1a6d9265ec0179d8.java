import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Example implementation: write bytes to a hypothetical destination
        for (byte value : b) {
            // Here you would write the byte to your output destination
            // For demonstration, we will just print the byte value
            System.out.print((char) value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the single byte write method if needed
        System.out.print((char) b);
    }
}