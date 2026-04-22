import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("The byte array is null");
        }
        // Assuming this is part of a larger OutputStream implementation
        // Here we just write the bytes to the underlying output stream
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // This method should be implemented to write a single byte to the output stream
        // For example, writing to a file or network stream
        // This is a placeholder implementation
        System.out.write(b);
    }
}