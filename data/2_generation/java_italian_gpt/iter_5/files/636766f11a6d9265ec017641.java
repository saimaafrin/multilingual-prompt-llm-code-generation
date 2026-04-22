import java.io.IOException;
import java.io.InputStream;

public class CustomInputStream extends InputStream {
    private final InputStream inputStream;

    public CustomInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    // Other methods can be implemented as needed
}