import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has a method to write a single byte.
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the logic to write a single byte to the output stream.
        // This is a placeholder implementation.
        System.out.write(b);
    }
}