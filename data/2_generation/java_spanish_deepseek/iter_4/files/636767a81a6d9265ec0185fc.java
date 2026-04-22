import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream inputStream;

    public TagReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Intenta leer una etiqueta de campo, devolviendo cero si hemos alcanzado el EOF. Los analizadores de mensajes de protocolo utilizan esto para leer etiquetas, ya que un mensaje de protocolo puede terminar legalmente donde ocurra una etiqueta, y cero no es un número de etiqueta válido.
     *
     * @return el valor de la etiqueta leída, o 0 si se alcanzó el EOF.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        return tag == -1 ? 0 : tag;
    }
}