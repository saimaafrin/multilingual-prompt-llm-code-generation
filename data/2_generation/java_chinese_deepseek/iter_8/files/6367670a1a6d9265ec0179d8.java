import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of a custom OutputStream implementation,
        // you would typically write the byte array to the underlying output stream.
        // For example, if this class had a reference to another OutputStream:
        // out.write(b);
    }
}