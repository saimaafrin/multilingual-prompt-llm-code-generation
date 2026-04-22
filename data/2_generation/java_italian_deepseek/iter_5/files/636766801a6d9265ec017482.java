import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
        this.readPointer = 0;
    }

    /**
     * Svuota e riempie il buffer di questo {@code ClassFileBuffer} con il flusso di byte fornito. 
     * Il puntatore di lettura viene ripristinato all'inizio dell'array di byte.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Svuota il buffer
        this.buffer = new byte[0];
        this.readPointer = 0;

        // Legge tutti i byte dall'InputStream
        byte[] tempBuffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byte[] newBuffer = new byte[this.buffer.length + bytesRead];
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.buffer.length);
            System.arraycopy(tempBuffer, 0, newBuffer, this.buffer.length, bytesRead);
            this.buffer = newBuffer;
        }

        // Ripristina il puntatore di lettura all'inizio del buffer
        this.readPointer = 0;
    }

    // Metodi aggiuntivi per gestire il buffer e il puntatore di lettura
    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }

    public void setReadPointer(int readPointer) {
        this.readPointer = readPointer;
    }
}