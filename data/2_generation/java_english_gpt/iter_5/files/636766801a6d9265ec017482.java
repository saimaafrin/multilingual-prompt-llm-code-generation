import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
    }

    /** 
     * Clear and fill the buffer of this {@code ClassFileBuffer} with the supplied byte stream. 
     * The read pointer is reset to the start of the byte array.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Clear the existing buffer
        this.buffer = new byte[0];

        // Use ByteArrayOutputStream to read the InputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream and write to the ByteArrayOutputStream
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byteArrayOutputStream.write(tempBuffer, 0, bytesRead);
        }

        // Convert the ByteArrayOutputStream to a byte array and set it to the buffer
        this.buffer = byteArrayOutputStream.toByteArray();
    }
}