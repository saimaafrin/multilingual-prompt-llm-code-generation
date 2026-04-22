import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("The byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has a method to write a single byte.
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // This method should be implemented to write a single byte.
        // For example, writing to a file or another output stream.
        // This is a placeholder implementation.
        System.out.write(b);
    }
}