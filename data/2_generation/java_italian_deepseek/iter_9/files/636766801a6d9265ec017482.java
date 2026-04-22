import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int readPointer;

    public ClassFileBuffer(int initialCapacity) {
        this.buffer = new byte[initialCapacity];
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

        // Legge i byte dall'InputStream e li scrive nel buffer
        int bytesRead;
        while ((bytesRead = in.read(this.buffer)) != -1) {
            // Se necessario, espande il buffer per contenere più dati
            if (this.readPointer + bytesRead > this.buffer.length) {
                byte[] newBuffer = new byte[this.buffer.length * 2];
                System.arraycopy(this.buffer, 0, newBuffer, 0, this.buffer.length);
                this.buffer = newBuffer;
            }
            this.readPointer += bytesRead;
        }

        // Ripristina il puntatore di lettura all'inizio del buffer
        this.readPointer = 0;
    }
}