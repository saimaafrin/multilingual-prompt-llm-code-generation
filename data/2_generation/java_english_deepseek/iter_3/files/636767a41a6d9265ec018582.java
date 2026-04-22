import java.io.IOException;
import java.io.OutputStream;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.ProtostuffIOUtil;

public class SerializationUtil {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @param out the output stream to write the serialized message to
     * @param message the message to serialize
     * @param schema the schema for the message
     * @param buffer the buffer to use for serialization
     * @return the size of the message
     * @throws IOException if an I/O error occurs
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a varint
        int length = data.length;
        int size = 0;
        while ((length & ~0x7F) != 0) {
            out.write((byte) ((length & 0x7F) | 0x80));
            length >>>= 7;
            size++;
        }
        out.write((byte) length);
        size++;

        // Write the serialized message
        out.write(data);
        size += data.length;

        return size;
    }
}