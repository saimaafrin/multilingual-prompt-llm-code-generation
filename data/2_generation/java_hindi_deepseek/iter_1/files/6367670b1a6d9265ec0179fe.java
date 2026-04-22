import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method is part of an OutputStream subclass
        // and we are writing to some underlying output stream.
        // For example, writing to System.out:
        System.out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream class.
        // It writes a single byte to the output stream.
        System.out.write(b);
    }

    public static void main(String[] args) {
        try {
            CustomOutputStream cos = new CustomOutputStream();
            byte[] data = "Hello, World!".getBytes();
            cos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}