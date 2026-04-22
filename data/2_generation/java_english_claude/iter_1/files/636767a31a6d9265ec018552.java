import java.io.IOException;
import java.io.DataInputStream;

public class BinaryReader {
    private DataInputStream input;

    public BinaryReader(DataInputStream input) {
        this.input = input;
    }

    /**
     * Read a {@code string} field value from the stream.
     */
    @Override
    public String readString() throws IOException {
        // Read string length first
        int length = input.readInt();
        
        if (length < 0) {
            return null;
        }

        // Create byte array to hold string data
        byte[] bytes = new byte[length];
        
        // Read bytes from stream
        input.readFully(bytes);
        
        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, "UTF-8");
    }
}