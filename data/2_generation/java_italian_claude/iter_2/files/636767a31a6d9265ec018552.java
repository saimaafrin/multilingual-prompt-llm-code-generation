import java.io.IOException;
import java.io.DataInputStream;

public class DataReader {
    private DataInputStream in;
    
    public DataReader(DataInputStream in) {
        this.in = in;
    }

    /**
     * Leggi un valore di campo {@code string} dallo stream.
     */
    @Override
    public String readString() throws IOException {
        // Read the string length first
        int length = in.readInt();
        
        if (length < 0) {
            return null;
        }
        
        // Create byte array to hold string data
        byte[] bytes = new byte[length];
        
        // Read the string bytes
        in.readFully(bytes);
        
        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, "UTF-8");
    }
}