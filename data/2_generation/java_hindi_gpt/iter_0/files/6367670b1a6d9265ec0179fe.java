import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte[] b) throws IOException {
        if (b == null) {
            throw new IOException("Byte array is null");
        }
        // Here you would implement the logic to write the byte array to the output stream.
        // For demonstration, we will just print the bytes to the console.
        for (byte value : b) {
            System.out.print((char) value); // Print each byte as a character
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementing the abstract method from OutputStream
        System.out.print((char) b); // Print the single byte as a character
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