import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("El arreglo de bytes no puede ser nulo.");
        }
        // Aquí se implementaría la lógica para escribir los bytes en el flujo de salida.
        // Por ejemplo, podrías escribir en un archivo, en la consola, etc.
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

    public static void main(String[] args) {
        try {
            CustomOutputStream stream = new CustomOutputStream();
            byte[] data = {72, 101, 108, 108, 111}; // "Hello" en bytes
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}