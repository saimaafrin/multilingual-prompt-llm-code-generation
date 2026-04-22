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
        // Clear the buffer by resetting the read pointer
        this.readPointer = 0;

        // Read the entire stream into the buffer
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            // If no bytes were read, reset the buffer to empty
            this.buffer = new byte[this.buffer.length];
        } else if (bytesRead < this.buffer.length) {
            // If fewer bytes were read than the buffer size, adjust the buffer
            byte[] newBuffer = new byte[bytesRead];
            System.arraycopy(this.buffer, 0, newBuffer, 0, bytesRead);
            this.buffer = newBuffer;
        }
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }
}