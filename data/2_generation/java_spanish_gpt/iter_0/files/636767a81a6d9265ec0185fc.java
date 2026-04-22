import java.io.IOException;
import java.io.InputStream;

public class ProtocolMessageParser {
    private InputStream inputStream;

    public ProtocolMessageParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /** 
     * Intenta leer una etiqueta de campo, devolviendo cero si hemos alcanzado el EOF. 
     * Los analizadores de mensajes de protocolo utilizan esto para leer etiquetas, 
     * ya que un mensaje de protocolo puede terminar legalmente donde ocurra una etiqueta, 
     * y cero no es un número de etiqueta válido.
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        if (tag == -1) {
            return 0; // EOF reached
        }
        return tag;
    }
}