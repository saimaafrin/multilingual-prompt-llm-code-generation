import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private byte[] byteBuffer;
    private int bufferSize;
    private int currentIndex;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
        this.byteBuffer = new byte[1024]; // Example buffer size
        this.bufferSize = 0;
        this.currentIndex = 0;
    }

    /** 
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        if (currentIndex >= bufferSize) {
            bufferSize = buffer.read(byteBuffer);
            currentIndex = 0;
            if (bufferSize == -1) {
                throw new IOException("No more data available.");
            }
        }
        return byteBuffer[currentIndex++];
    }
}