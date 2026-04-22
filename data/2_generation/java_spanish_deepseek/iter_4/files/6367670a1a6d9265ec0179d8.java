import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        // Assuming this method writes the byte array to some output destination
        // For example, writing to System.out
        System.out.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream class
        // It can be implemented to handle single byte writes
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