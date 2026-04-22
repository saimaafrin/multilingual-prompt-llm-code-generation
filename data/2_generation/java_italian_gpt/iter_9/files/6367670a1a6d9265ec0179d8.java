import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    
    @Override 
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Example implementation: write bytes to a hypothetical output
        for (byte value : b) {
            // Here you would write the byte to the actual output destination
            System.out.write(value); // This is just for demonstration
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementation for writing a single byte
        System.out.write(b); // This is just for demonstration
    }
}