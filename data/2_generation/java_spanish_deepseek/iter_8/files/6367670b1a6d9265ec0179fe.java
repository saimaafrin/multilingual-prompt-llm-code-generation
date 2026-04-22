import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        // Escribe todos los bytes del arreglo en el flujo de salida
        for (byte value : b) {
            write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementación básica para escribir un solo byte
        // Este método debe ser sobrescrito en una implementación real
        throw new UnsupportedOperationException("Método no implementado");
    }
}