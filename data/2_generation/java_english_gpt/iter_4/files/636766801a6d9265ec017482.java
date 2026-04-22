import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
        this.readPointer = 0;
    }

    /** 
     * Clear and fill the buffer of this {@code ClassFileBuffer} with the supplied byte stream. 
     * The read pointer is reset to the start of the byte array.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Clear the existing buffer
        this.buffer = new byte[0];
        this.readPointer = 0;

        // Use ByteArrayOutputStream to read the InputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream until the end
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byteArrayOutputStream.write(tempBuffer, 0, bytesRead);
        }

        // Convert the ByteArrayOutputStream to a byte array
        this.buffer = byteArrayOutputStream.toByteArray();
        this.readPointer = 0; // Reset read pointer to the start
    }
}