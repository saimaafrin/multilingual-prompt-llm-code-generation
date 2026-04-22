import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public void readFrom(final InputStream in) throws IOException {
        // Clear the buffer
        buffer = null;
        readPointer = 0;

        // Read the input stream into the buffer
        buffer = in.readAllBytes();
    }
}