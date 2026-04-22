import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has access to the underlying output mechanism.
        // For example, writing to a file or network stream.
        // Here, we just print the bytes to the console as an example.
        for (byte value : b) {
            System.out.print((char) value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream class.
        // It writes a single byte to the output stream.
        System.out.write(b);
    }

    public static void main(String[] args) {
        try {
            CustomOutputStream stream = new CustomOutputStream();
            byte[] data = "Hello, World!".getBytes();
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}