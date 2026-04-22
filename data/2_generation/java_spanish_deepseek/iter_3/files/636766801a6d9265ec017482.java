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
     * Limpia y llena el búfer de este {@code ClassFileBuffer} con el flujo de bytes proporcionado. 
     * El puntero de lectura se restablece al inicio del arreglo de bytes.
     */
    public void readFrom(final InputStream in) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("InputStream no puede ser nulo");
        }

        // Limpiar el buffer
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }

        // Leer los bytes del InputStream y llenar el buffer
        int bytesRead = in.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("No se pudieron leer bytes del InputStream");
        }

        // Restablecer el puntero de lectura al inicio del buffer
        readPointer = 0;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getReadPointer() {
        return readPointer;
    }
}