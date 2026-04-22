import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputStream extends OutputStream {

    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Desplazamiento o longitud fuera de los límites del arreglo.");
        }
        for (int i = off; i < off + len; i++) {
            write(b[i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementación para escribir un solo byte.
        // Este método debe ser implementado según la lógica específica del flujo de salida.
        // Por ejemplo, podría escribir el byte en un archivo, en la consola, etc.
        System.out.write(b);
    }
}