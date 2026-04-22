import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer(int bufferSize) {
        this.buffer = new byte[bufferSize];
        this.readPointer = 0;
    }

    /**
     * Svuota e riempie il buffer di questo {@code ClassFileBuffer} con il flusso di byte fornito. 
     * Il puntatore di lettura viene ripristinato all'inizio dell'array di byte.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Svuota il buffer
        this.buffer = new byte[this.buffer.length];
        this.readPointer = 0;

        // Legge i byte dall'InputStream e li inserisce nel buffer
        int bytesRead;
        while ((bytesRead = in.read(this.buffer, this.readPointer, this.buffer.length - this.readPointer)) != -1) {
            this.readPointer += bytesRead;
            if (this.readPointer >= this.buffer.length) {
                break;
            }
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