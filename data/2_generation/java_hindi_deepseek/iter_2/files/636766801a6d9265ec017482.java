import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer(int bufferSize) {
        this.buffer = new byte[bufferSize];
        this.readPointer = 0;
    }

    /**
     * इस {@code ClassFileBuffer} के बफर को प्रदान किए गए बाइट स्ट्रीम से साफ़ और भरें। पढ़ने का पॉइंटर बाइट एरे के शुरू में रीसेट किया जाता है।
     */
    public void readFrom(final InputStream in) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        // Clear the buffer
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }

        // Read data from the InputStream into the buffer
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("End of stream reached before reading any data");
        }

        // Reset the read pointer to the beginning of the buffer
        readPointer = 0;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }
}