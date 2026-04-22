import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;

public class StreamReader {
    private DataInputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = new DataInputStream(inputStream);
    }

    /**
     * Leggi un valore di campo {@code string} dallo stream.
     */
    @Override
    public String readString() throws IOException {
        return inputStream.readUTF();
    }
}