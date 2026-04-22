import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String readString() throws IOException {
        int length = readVarInt();
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Unexpected end of stream");
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private int readVarInt() throws IOException {
        int value = 0;
        int shift = 0;
        int b;
        do {
            b = inputStream.read();
            if (b == -1) {
                throw new IOException("Unexpected end of stream");
            }
            value |= (b & 0x7F) << shift;
            shift += 7;
        } while ((b & 0x80) != 0);
        return value;
    }
}