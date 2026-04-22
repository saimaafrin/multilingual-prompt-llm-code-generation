import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayConverter {

    private ByteArrayOutputStream outputStream;

    public ByteArrayConverter() {
        this.outputStream = new ByteArrayOutputStream();
    }

    /**
     * Copia bytes a un {@code byte[]}.
     * @return array de bytes con el contenido del stream
     */
    public byte[] toByteArray() {
        return outputStream.toByteArray();
    }
}