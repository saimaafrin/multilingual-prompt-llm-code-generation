import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("The byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has access to some underlying output mechanism.
        // For example, writing to a file or network stream.
        // Here, we just print the bytes to the console as an example.
        for (byte value : b) {
            System.out.print(value + " ");
        }
        System.out.println(); // Print a newline after writing all bytes
    }
}