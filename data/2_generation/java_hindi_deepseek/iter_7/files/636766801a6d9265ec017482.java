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

        // Clear the buffer and reset the read pointer
        this.readPointer = 0;
        int bytesRead = in.read(this.buffer);

        if (bytesRead == -1) {
            throw new IOException("End of stream reached before reading any data");
        }
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }
}