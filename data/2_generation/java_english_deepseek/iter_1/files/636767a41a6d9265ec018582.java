import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.io.DatumWriter;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;

public class SerializationUtil {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @return the size of the message
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message using Protostuff
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a prefix
        int length = data.length;
        out.write((length >>> 24) & 0xFF);
        out.write((length >>> 16) & 0xFF);
        out.write((length >>> 8) & 0xFF);
        out.write(length & 0xFF);

        // Write the serialized message
        out.write(data);

        // Return the total size of the message (length prefix + data)
        return 4 + length;
    }
}