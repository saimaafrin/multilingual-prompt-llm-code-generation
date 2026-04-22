import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        // Aquí se implementaría la lógica para escribir los bytes en el flujo de salida.
        // Por ejemplo, podrías escribir en un archivo, un socket, etc.
        // Este es un ejemplo básico que simplemente imprime los bytes en la consola.
        for (byte value : b) {
            System.out.write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementación del método abstracto de la clase OutputStream.
        System.out.write(b);
    }
}