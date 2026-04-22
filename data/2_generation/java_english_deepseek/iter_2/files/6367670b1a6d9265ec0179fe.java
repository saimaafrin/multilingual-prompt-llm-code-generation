import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of a custom OutputStream implementation
        // Here, you would write the bytes to the desired output destination
        // For example, writing to a file, network stream, etc.
        // This is a placeholder implementation:
        for (byte value : b) {
            write(value); // Call the single-byte write method
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the single-byte write method
        // This is a placeholder implementation:
        System.out.write(b); // Example: writing to standard output
    }
}