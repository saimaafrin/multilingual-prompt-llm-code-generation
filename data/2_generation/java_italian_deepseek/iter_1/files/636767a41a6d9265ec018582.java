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
        try (MessagePacker packer = MessagePack.newDefaultPacker(buffer)) {
            // Serialize the message using the schema
            schema.write(packer, message);

            // Get the serialized message as a byte array
            byte[] serializedMessage = packer.toByteArray();

            // Write the length of the message as a varint
            MessageBufferPacker lengthPacker = MessagePack.newDefaultBufferPacker();
            lengthPacker.packInt(serializedMessage.length);

            // Write the length and the serialized message to the output stream
            out.write(lengthPacker.toByteArray());
            out.write(serializedMessage);

            // Return the total size of the message (length + serialized message)
            return lengthPacker.toByteArray().length + serializedMessage.length;
        }
    }
}