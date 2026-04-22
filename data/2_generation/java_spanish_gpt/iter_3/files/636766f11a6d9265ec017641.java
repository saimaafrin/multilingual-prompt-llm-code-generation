import java.io.IOException;
import java.io.InputStream;

public class CustomInputStream extends InputStream {
    private byte[] data;
    private int currentIndex;

    public CustomInputStream(byte[] data) {
        this.data = data;
        this.currentIndex = 0;
    }

    @Override
    public int available() throws IOException {
        return data.length - currentIndex;
    }

    @Override
    public int read() throws IOException {
        if (currentIndex >= data.length) {
            return -1; // End of stream
        }
        return data[currentIndex++] & 0xFF; // Return byte as int
    }

    // Other methods can be implemented as needed
}