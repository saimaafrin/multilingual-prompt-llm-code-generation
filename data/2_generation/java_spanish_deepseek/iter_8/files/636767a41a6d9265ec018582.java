import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.BinaryEncoder;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;

public class SerializationUtil {

    /**
     * Serializa el {@code message}, precedido por su longitud, en un {@link OutputStream}.
     * @return el tamaño del mensaje
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serializar el mensaje usando Protostuff
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Escribir la longitud del mensaje como un entero de 4 bytes (big-endian)
        out.write((data.length >>> 24) & 0xFF);
        out.write((data.length >>> 16) & 0xFF);
        out.write((data.length >>> 8) & 0xFF);
        out.write(data.length & 0xFF);

        // Escribir los datos serializados
        out.write(data);

        // Retornar el tamaño total del mensaje (longitud + datos)
        return 4 + data.length;
    }
}