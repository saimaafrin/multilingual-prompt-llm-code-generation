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

        // Legge i byte dall'InputStream e li scrive nel buffer
        int bytesRead;
        while ((bytesRead = in.read(this.buffer)) != -1) {
            // Se il buffer è pieno, esce dal ciclo
            if (bytesRead < this.buffer.length) {
                break;
            }
        }

        // Ripristina il puntatore di lettura all'inizio del buffer
        this.readPointer = 0;
    }

    // Altri metodi della classe...
}