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
        // Implementación de la escritura de un solo byte
        // Aquí se puede agregar la lógica para escribir el byte en el flujo de salida
        System.out.write(b);
    }
}