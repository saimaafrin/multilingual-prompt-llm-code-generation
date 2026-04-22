import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayCopier {

    /**
     * Copies bytes to a {@code byte[]}.
     * @param input The input stream to read from
     * @return The bytes read from the input stream
     * @throws IOException If an I/O error occurs
     */
    public static byte[] copyToByteArray(InputStream input) throws IOException {
        if (input == null) {
            return new byte[0];
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}