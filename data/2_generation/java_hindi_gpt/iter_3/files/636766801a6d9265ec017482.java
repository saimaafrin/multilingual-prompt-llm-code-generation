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
     * इस {@code ClassFileBuffer} के बफर को प्रदान किए गए बाइट स्ट्रीम से साफ़ और भरें। पढ़ने का पॉइंटर बाइट एरे के शुरू में रीसेट किया जाता है।
     */
    public void readFrom(final InputStream in) throws IOException {
        readPointer = 0; // Reset the read pointer
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("End of stream reached before reading any bytes.");
        }
    }
}