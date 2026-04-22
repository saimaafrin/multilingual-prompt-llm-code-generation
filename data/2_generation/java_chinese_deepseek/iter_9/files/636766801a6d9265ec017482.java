import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer(int bufferSize) {
        this.buffer = new byte[bufferSize];
        this.readPointer = 0;
    }

    public void readFrom(final InputStream in) throws IOException {
        // Clear the buffer
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }

        // Read from the InputStream into the buffer
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("End of stream reached");
        }

        // Reset the read pointer to the start of the buffer
        readPointer = 0;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }
}