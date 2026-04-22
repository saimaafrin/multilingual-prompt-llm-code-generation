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
        // Here, we just simulate writing by printing the bytes.
        for (byte value : b) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    @Override
    public void write(int b) throws IOException {
        // This method is required by the OutputStream class.
        // It writes a single byte.
        System.out.print(b + " ");
    }

    public static void main(String[] args) {
        try {
            MyOutputStream outputStream = new MyOutputStream();
            byte[] data = {65, 66, 67, 68}; // Example byte array
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}