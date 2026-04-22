import java.util.Arrays;

public class MessageBody {
    private byte[] bodyBytes;
    
    /**
     * Verdadero si el cuerpo es un arreglo de bytes
     * @return Verdadero si el cuerpo es un arreglo de bytes
     */
    public boolean hasBytes() {
        return bodyBytes != null && bodyBytes.length > 0;
    }
}