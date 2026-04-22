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
        this.buffer = new byte[this.buffer.length];
        this.readPointer = 0;

        // Read data from the InputStream into the buffer
        int bytesRead;
        while ((bytesRead = in.read(this.buffer, this.readPointer, this.buffer.length - this.readPointer)) != -1) {
            this.readPointer += bytesRead;
            if (this.readPointer >= this.buffer.length) {
                break; // Buffer is full
            }
        }
    }
}