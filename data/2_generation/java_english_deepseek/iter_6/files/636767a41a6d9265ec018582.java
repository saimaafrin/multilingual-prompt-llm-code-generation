import java.io.IOException;
import java.io.OutputStream;
import org.objenesis.strategy.StdInstantiatorStrategy;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;

public class SerializationUtil {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @return the size of the message
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a varint
        int length = data.length;
        int size = 0;
        while ((length & ~0x7F) != 0) {
            out.write((length & 0x7F) | 0x80);
            length >>>= 7;
            size++;
        }
        out.write(length);
        size++;

        // Write the serialized message
        out.write(data);
        size += data.length;

        return size;
    }
}