import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        write(b, 0, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites.");
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementación específica para escribir un solo byte.
        // Este método debe ser implementado por la subclase.
        throw new IOException("Método no implementado.");
    }
}