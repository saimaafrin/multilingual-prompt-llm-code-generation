import java.io.IOException;
import java.io.OutputStream;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;

public class DelimitedMessageWriter {

    /**
     * Serializa el {@code message}, precedido por su longitud, en un {@link OutputStream}.
     * @param out El OutputStream donde se escribirá el mensaje.
     * @param message El mensaje a serializar.
     * @param schema El esquema utilizado para serializar el mensaje.
     * @param buffer El buffer utilizado para la serialización.
     * @return el tamaño del mensaje serializado.
     * @throws IOException Si ocurre un error de I/O durante la escritura.
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serializa el mensaje en un array de bytes
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Escribe la longitud del mensaje como un entero de 4 bytes (big-endian)
        out.write((data.length >>> 24) & 0xFF);
        out.write((data.length >>> 16) & 0xFF);
        out.write((data.length >>> 8) & 0xFF);
        out.write(data.length & 0xFF);

        // Escribe el mensaje serializado
        out.write(data);

        // Retorna el tamaño total del mensaje (4 bytes de longitud + tamaño del mensaje)
        return 4 + data.length;
    }
}