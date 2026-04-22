import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        write(b, 0, b.length);
    }

    @Override
    public void write(int b) throws IOException {
        // Required abstract method implementation
        throw new UnsupportedOperationException("write(int) not implemented");
    }
}