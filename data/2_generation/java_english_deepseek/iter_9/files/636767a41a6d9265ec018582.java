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
        byte[] serializedMessage = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the serialized message as a varint
        writeVarint(out, serializedMessage.length);

        // Write the serialized message to the output stream
        out.write(serializedMessage);

        // Return the size of the serialized message
        return serializedMessage.length;
    }

    private static void writeVarint(OutputStream out, int value) throws IOException {
        while (true) {
            if ((value & ~0x7F) == 0) {
                out.write(value);
                return;
            } else {
                out.write((value & 0x7F) | 0x80);
                value >>>= 7;
            }
        }
    }
}