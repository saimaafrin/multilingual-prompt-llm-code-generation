import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private byte[] byteBuffer;
    private int bufferSize;
    private int currentIndex;

    public ByteReader(InputStream buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
        this.byteBuffer = new byte[bufferSize];
        this.currentIndex = 0;
    }

    /** 
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        if (currentIndex >= byteBuffer.length) {
            int bytesRead = buffer.read(byteBuffer);
            if (bytesRead == -1) {
                throw new IOException("No more data available.");
            }
            currentIndex = 0;
        }
        return byteBuffer[currentIndex++];
    }
}