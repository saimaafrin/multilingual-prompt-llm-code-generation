import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public void readFrom(final InputStream in) throws IOException {
        // Clear the existing buffer
        buffer = null;
        readPointer = 0;

        // Read all bytes from the input stream
        buffer = in.readAllBytes();
    }
}