import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private int currentByte;
    
    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
        this.currentByte = -1;
    }

    /** 
     * Lee un byte del <code>buffer</code> y lo vuelve a llenar según sea necesario.
     * @return El siguiente byte del flujo de entrada.
     * @throws IOException si no hay más datos disponibles.
     */
    public byte readByte() throws IOException {
        if (currentByte == -1) {
            currentByte = buffer.read();
            if (currentByte == -1) {
                throw new IOException("No hay más datos disponibles.");
            }
        }
        byte result = (byte) currentByte;
        currentByte = -1; // Reset for the next read
        return result;
    }
}