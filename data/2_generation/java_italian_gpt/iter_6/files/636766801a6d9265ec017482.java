import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;

    public ClassFileBuffer() {
        this.buffer = new byte[0];
    }

    /** 
     * Svuota e riempie il buffer di questo {@code ClassFileBuffer} con il flusso di byte fornito. 
     * Il puntatore di lettura viene ripristinato all'inizio dell'array di byte.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Clear the existing buffer
        buffer = new byte[0];

        // Use ByteArrayOutputStream to read the InputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream and write to the ByteArrayOutputStream
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byteArrayOutputStream.write(tempBuffer, 0, bytesRead);
        }

        // Convert the ByteArrayOutputStream to a byte array and set it to the buffer
        buffer = byteArrayOutputStream.toByteArray();
    }
}