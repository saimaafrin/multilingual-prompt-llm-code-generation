import java.io.DataInputStream;
import java.io.IOException;

public class StringReader {
    /**
     * Read a string field value from the stream.
     * @param in The DataInputStream to read from
     * @return The string value read from the stream
     * @throws IOException If an I/O error occurs
     */
    public String readString(DataInputStream in) throws IOException {
        // Read string length
        int length = in.readInt();
        
        if (length < 0) {
            return null;
        }
        
        // Create byte array to hold string data
        byte[] bytes = new byte[length];
        
        // Read bytes into array
        in.readFully(bytes);
        
        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, "UTF-8");
    }
}