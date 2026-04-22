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
     * Lee un byte del <code>buffer</code> y lo vuelve a llenar según sea necesario.
     * @return El siguiente byte del flujo de entrada.
     * @throws IOException si no hay más datos disponibles.
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