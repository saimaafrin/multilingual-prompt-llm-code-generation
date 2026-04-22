import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StringReader {
    private DataInputStream dataInputStream;

    public StringReader(InputStream inputStream) {
        this.dataInputStream = new DataInputStream(inputStream);
    }

    /** 
     * Read a  {@code string} field value from the stream.
     */
    @Override 
    public String readString() throws IOException {
        int length = dataInputStream.readInt();
        byte[] bytes = new byte[length];
        dataInputStream.readFully(bytes);
        return new String(bytes, "UTF-8");
    }
}