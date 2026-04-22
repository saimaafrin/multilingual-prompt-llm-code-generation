import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;
    private int position;
    private int length;
    
    /**
     * Limpia y llena el búfer de este {@code ClassFileBuffer} con el flujo de bytes proporcionado.
     * El puntero de lectura se restablece al inicio del arreglo de bytes.
     */
    public void readFrom(final InputStream in) throws IOException {
        // Reset buffer state
        position = 0;
        length = 0;
        
        // If buffer hasn't been initialized yet, create initial buffer
        if (buffer == null) {
            buffer = new byte[4096]; // Initial size of 4KB
        }
        
        // Read bytes from input stream
        int bytesRead;
        int totalBytesRead = 0;
        
        while ((bytesRead = in.read(buffer, totalBytesRead, buffer.length - totalBytesRead)) != -1) {
            totalBytesRead += bytesRead;
            
            // If buffer is full, resize it
            if (totalBytesRead == buffer.length) {
                byte[] newBuffer = new byte[buffer.length * 2];
                System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
                buffer = newBuffer;
            }
        }
        
        // Set final length
        length = totalBytesRead;
        
        // If buffer is significantly larger than needed, trim it
        if (buffer.length > length * 2) {
            byte[] trimmedBuffer = new byte[length];
            System.arraycopy(buffer, 0, trimmedBuffer, 0, length);
            buffer = trimmedBuffer;
        }
    }
}