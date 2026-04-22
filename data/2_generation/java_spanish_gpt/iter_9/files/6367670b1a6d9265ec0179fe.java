import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new IOException("El arreglo de bytes no puede ser nulo.");
        }
        // Aquí se implementaría la lógica para escribir los bytes en el flujo de salida.
        // Por ejemplo, podríamos escribir en un archivo o en un socket.
        // Este es un ejemplo simple que solo imprime los bytes en la consola.
        for (byte value : b) {
            System.out.print((char) value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementación del método write para un solo byte
        System.out.print((char) b);
    }
    
    public static void main(String[] args) {
        CustomOutputStream customOutputStream = new CustomOutputStream();
        try {
            byte[] data = "Hola, mundo!".getBytes();
            customOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}