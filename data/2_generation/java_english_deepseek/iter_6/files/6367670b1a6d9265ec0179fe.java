import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Assuming this is part of a custom OutputStream implementation
        // Here, you would write the bytes to the desired destination
        // For example, writing to a file, network stream, etc.
        // This is a placeholder implementation.
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Placeholder implementation for writing a single byte
        // This method must be implemented in a subclass
        throw new UnsupportedOperationException("Single byte write not implemented");
    }
}