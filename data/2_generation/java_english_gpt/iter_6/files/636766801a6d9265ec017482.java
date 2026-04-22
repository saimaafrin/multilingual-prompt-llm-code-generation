import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer(int size) {
        this.buffer = new byte[size];
        this.readPointer = 0;
    }

    /** 
     * Clear and fill the buffer of this {@code ClassFileBuffer} with the supplied byte stream. 
     * The read pointer is reset to the start of the byte array.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Clear the buffer
        readPointer = 0;

        // Read bytes from the InputStream
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("End of stream reached before reading any bytes.");
        }

        // Reset the read pointer to the start of the byte array
        readPointer = 0;
    }
}