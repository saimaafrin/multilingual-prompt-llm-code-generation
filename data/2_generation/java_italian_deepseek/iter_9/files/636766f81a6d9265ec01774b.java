import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream inputStream;
    private byte[] buffer;
    private int bufferPosition;
    private int bufferLength;

    public ByteReader(InputStream inputStream, int bufferSize) {
        this.inputStream = inputStream;
        this.buffer = new byte[bufferSize];
        this.bufferPosition = 0;
        this.bufferLength = 0;
    }

    /**
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        if (bufferPosition >= bufferLength) {
            bufferLength = inputStream.read(buffer);
            if (bufferLength == -1) {
                throw new IOException("No more data available");
            }
            bufferPosition = 0;
        }
        return buffer[bufferPosition++];
    }
}