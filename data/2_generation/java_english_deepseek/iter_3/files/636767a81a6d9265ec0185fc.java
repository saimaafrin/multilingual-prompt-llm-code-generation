import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream inputStream;

    public TagReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Attempt to read a field tag, returning zero if we have reached EOF. Protocol message parsers use this to read tags,
     * since a protocol message may legally end wherever a tag occurs, and zero is not a valid tag number.
     *
     * @return the tag read, or 0 if EOF is reached
     * @throws IOException if an I/O error occurs
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        if (tag == -1) {
            return 0; // EOF reached
        }
        return tag;
    }
}