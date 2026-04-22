import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayExample {

    /** 
     * Copia bytes a un {@code byte[]}.
     */
    public byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            // Simulating writing bytes to the output stream
            byteArrayOutputStream.write(new byte[]{1, 2, 3, 4, 5});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayExample example = new ByteArrayExample();
        byte[] result = example.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}