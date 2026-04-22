import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Assuming this is a custom implementation that writes to a file or another stream
        // For example, writing to System.out as a placeholder
        System.out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        // Implement this method if needed, or throw UnsupportedOperationException
        throw new UnsupportedOperationException("Single byte write not supported");
    }

    public static void main(String[] args) {
        try {
            CustomOutputStream customOutputStream = new CustomOutputStream();
            byte[] data = "Hello, World!".getBytes();
            customOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}