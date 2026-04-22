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
        // This is a placeholder implementation that simply writes to System.out
        System.out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream abstract class
        // It writes a single byte to the output stream
        System.out.write(b);
    }
}