import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        // Implementación para escribir un solo byte
    }

    /**
     * Escribe <code>len</code> bytes desde el arreglo de bytes especificado comenzando en el desplazamiento <code>off</code> a este flujo de salida de bytes.
     * @param b   los datos.
     * @param off el desplazamiento inicial en los datos.
     * @param len el número de bytes a escribir.
     */
    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Desplazamiento o longitud fuera de los límites del arreglo.");
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }
}