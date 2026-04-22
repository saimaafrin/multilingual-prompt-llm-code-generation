import java.io.IOException;
import java.io.InputStream;

public class BufferedReader {
    private byte[] buffer;
    private int pos;
    private int count;
    private InputStream in;
    private static final int BUFFER_SIZE = 8192;

    public BufferedReader(InputStream in) {
        this.in = in;
        this.buffer = new byte[BUFFER_SIZE];
        this.pos = 0;
        this.count = 0;
    }

    /**
     * Lee un byte del <code>buffer</code> y lo vuelve a llenar según sea necesario.
     * @return El siguiente byte del flujo de entrada.
     * @throws IOException si no hay más datos disponibles.
     */
    public byte readByte() throws IOException {
        if (pos >= count) {
            count = in.read(buffer);
            if (count == -1) {
                throw new IOException("No hay más datos disponibles");
            }
            pos = 0;
        }
        return buffer[pos++];
    }
}