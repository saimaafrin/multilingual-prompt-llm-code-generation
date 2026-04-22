import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.schema.Schema;

public class MessageSerializer {

    /**
     * Serializza il {@code message}, precedendolo con la sua lunghezza, in un {@link OutputStream}.
     * @return la dimensione del messaggio
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        try (MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer)) {
            // Serialize the message using the schema
            schema.write(packer, message);

            // Get the serialized message as a byte array
            byte[] serializedMessage = packer.toByteArray();

            // Write the length of the message as a 4-byte integer
            out.write((serializedMessage.length >> 24) & 0xFF);
            out.write((serializedMessage.length >> 16) & 0xFF);
            out.write((serializedMessage.length >> 8) & 0xFF);
            out.write(serializedMessage.length & 0xFF);

            // Write the serialized message
            out.write(serializedMessage);

            // Return the total size of the message (length + serialized message)
            return 4 + serializedMessage.length;
        }
    }
}