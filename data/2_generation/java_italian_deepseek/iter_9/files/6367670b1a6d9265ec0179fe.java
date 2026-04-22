import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of a class that extends OutputStream
        // and has access to the underlying output mechanism.
        // For example, writing to a file or network stream.
        // Here, we just print the bytes to the standard output as an example.
        System.out.write(b, 0, b.length);
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream class.
        // It writes a single byte to the output stream.
        System.out.write(b);
    }

    public static void main(String[] args) {
        try {
            MyOutputStream outputStream = new MyOutputStream();
            byte[] data = "Hello, World!".getBytes();
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}