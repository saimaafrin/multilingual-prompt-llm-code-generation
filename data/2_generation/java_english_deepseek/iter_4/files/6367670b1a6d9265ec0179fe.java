import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this is part of a custom OutputStream implementation
        // Here you would write the bytes to the desired destination
        // For example, writing to a file or another stream
        // This is a placeholder for the actual implementation
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Placeholder for writing a single byte
        // This method must be implemented in a subclass
        throw new UnsupportedOperationException("Single byte write not implemented");
    }
}