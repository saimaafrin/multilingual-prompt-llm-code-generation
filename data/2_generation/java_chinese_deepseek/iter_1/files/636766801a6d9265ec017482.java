import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public void readFrom(final InputStream in) throws IOException {
        // Clear the buffer and reset the read pointer
        buffer = in.readAllBytes();
        readPointer = 0;
    }
}