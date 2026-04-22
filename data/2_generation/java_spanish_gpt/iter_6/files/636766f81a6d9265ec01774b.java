import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private byte[] byteBuffer;
    private int bufferSize;
    private int currentIndex;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
        this.byteBuffer = new byte[1024]; // Buffer size can be adjusted
        this.bufferSize = 0;
        this.currentIndex = 0;
    }

    /**
     * Lee un byte del <code>buffer</code> y lo vuelve a llenar según sea necesario.
     * @return El siguiente byte del flujo de entrada.
     * @throws IOException si no hay más datos disponibles.
     */
    public byte readByte() throws IOException {
        if (currentIndex >= bufferSize) {
            bufferSize = buffer.read(byteBuffer);
            currentIndex = 0;
            if (bufferSize == -1) {
                throw new IOException("No hay más datos disponibles.");
            }
        }
        return byteBuffer[currentIndex++];
    }
}