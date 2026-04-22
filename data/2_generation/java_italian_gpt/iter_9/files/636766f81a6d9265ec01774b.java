import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
    }

    /** 
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        int data = buffer.read();
        if (data == -1) {
            throw new IOException("No more data available.");
        }
        return (byte) data;
    }
}