import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Implement the logic to write the byte array to the output stream
        // For example, writing to a file or another output stream
        // This is a placeholder implementation
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the logic to write a single byte to the output stream
        // This is a placeholder implementation
        System.out.write(b);
    }

    public static void main(String[] args) {
        try {
            CustomOutputStream outputStream = new CustomOutputStream();
            byte[] data = "Hello, World!".getBytes();
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}