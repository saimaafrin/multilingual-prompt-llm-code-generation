import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public void readFrom(final InputStream in) throws IOException {
        // Clear the buffer by setting it to null
        this.buffer = null;
        this.readPointer = 0;

        // Read all bytes from the input stream
        this.buffer = in.readAllBytes();

        // Reset the read pointer to the start of the buffer
        this.readPointer = 0;
    }
}