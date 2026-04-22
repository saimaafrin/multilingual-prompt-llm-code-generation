import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("The byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has access to the underlying output mechanism.
        // For example, writing to a file or network stream.
        // Here, we just simulate writing by printing the bytes.
        for (byte value : b) {
            System.out.print(value + " ");
        }
        System.out.println(); // New line after writing all bytes
    }
}