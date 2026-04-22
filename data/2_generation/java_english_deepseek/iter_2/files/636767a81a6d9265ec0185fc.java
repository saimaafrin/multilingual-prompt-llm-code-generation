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
        int firstByte = inputStream.read();
        if (firstByte == -1) {
            return 0; // EOF reached
        }

        int tag = firstByte & 0x7F; // Extract the lower 7 bits
        if ((firstByte & 0x80) != 0) {
            // More bytes to read for the tag
            int shift = 7;
            while (true) {
                int nextByte = inputStream.read();
                if (nextByte == -1) {
                    throw new IOException("Unexpected EOF while reading tag");
                }
                tag |= (nextByte & 0x7F) << shift;
                if ((nextByte & 0x80) == 0) {
                    break;
                }
                shift += 7;
            }
        }

        return tag;
    }
}