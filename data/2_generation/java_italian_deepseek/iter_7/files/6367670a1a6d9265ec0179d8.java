import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Implement the logic to write the byte array to the output stream
        // For example, writing to System.out:
        System.out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the logic to write a single byte to the output stream
        // For example, writing to System.out:
        System.out.write(b);
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