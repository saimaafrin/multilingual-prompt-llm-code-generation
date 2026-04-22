import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new IOException("Byte array is null");
        }
        // Here you would typically write the bytes to the underlying output stream.
        // For demonstration, we will just print the bytes to the console.
        for (byte value : b) {
            System.out.print((char) value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementing the write method for a single byte
        System.out.print((char) b);
    }

    public static void main(String[] args) {
        CustomOutputStream customOutputStream = new CustomOutputStream();
        try {
            byte[] data = "Hello, World!".getBytes();
            customOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}