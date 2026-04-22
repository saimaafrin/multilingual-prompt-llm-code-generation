import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream input;

    public TagReader(InputStream input) {
        this.input = input;
    }

    /**
     * Attempt to read a field tag, returning zero if we have reached EOF. Protocol message parsers use this to read tags, since a protocol message may legally end wherever a tag occurs, and zero is not a valid tag number.
     */
    public int readTag() throws IOException {
        int firstByte = input.read();
        if (firstByte == -1) {
            return 0; // EOF reached
        }
        return firstByte;
    }
}