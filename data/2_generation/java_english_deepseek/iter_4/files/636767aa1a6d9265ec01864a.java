import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayConverter {

    /**
     * Copies bytes to a {@code byte[]}.
     *
     * @return a byte array containing the copied bytes
     */
    public byte[] toByteArray() {
        // Example implementation: Convert a string to a byte array
        String exampleData = "Hello, World!";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(exampleData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayConverter converter = new ByteArrayConverter();
        byte[] byteArray = converter.toByteArray();
        System.out.println(new String(byteArray)); // Output: Hello, World!
    }
}