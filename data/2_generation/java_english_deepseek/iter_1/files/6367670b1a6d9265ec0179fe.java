import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Assuming this is part of a larger OutputStream implementation
        // Here we would write the bytes to the underlying output stream
        // For example, if this were a FileOutputStream, we would write to the file
        // For demonstration purposes, we'll just print the bytes to the console
        for (byte value : b) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}