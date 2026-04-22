import java.io.IOException;
import java.io.InputStream;

public class StreamReader {

    private InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Leggi un valore di campo {@code string} dallo stream.
     */
    @Override
    public String readString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int data;
        while ((data = inputStream.read()) != -1) {
            char character = (char) data;
            if (character == '\n' || character == '\r') {
                break; // Stop reading at newline or carriage return
            }
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}