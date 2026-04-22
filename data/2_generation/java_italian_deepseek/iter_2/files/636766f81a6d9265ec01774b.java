import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class ByteReader {
    private ByteBuffer buffer;
    private InputStream inputStream;

    public ByteReader(ByteBuffer buffer, InputStream inputStream) {
        this.buffer = buffer;
        this.inputStream = inputStream;
    }

    /**
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        if (!buffer.hasRemaining()) {
            refillBuffer();
        }
        try {
            return buffer.get();
        } catch (BufferUnderflowException e) {
            throw new IOException("No more data available", e);
        }
    }

    private void refillBuffer() throws IOException {
        buffer.clear();
        int bytesRead = inputStream.read(buffer.array());
        if (bytesRead == -1) {
            throw new IOException("No more data available");
        }
        buffer.limit(bytesRead);
    }
}