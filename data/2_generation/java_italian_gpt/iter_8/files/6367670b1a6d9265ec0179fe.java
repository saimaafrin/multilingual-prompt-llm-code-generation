import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new IOException("Byte array cannot be null");
        }
        // Here you would implement the logic to write the bytes to the output stream.
        // For demonstration purposes, we will just print the bytes to the console.
        for (byte value : b) {
            System.out.print((char) value); // Assuming the bytes represent characters
        }
        System.out.flush(); // Ensure all data is written out
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the method to write a single byte if needed
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