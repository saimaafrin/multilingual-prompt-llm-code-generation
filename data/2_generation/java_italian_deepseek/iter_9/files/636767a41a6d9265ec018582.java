import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.schema.Schema;

public class MessageSerializer {

    /**
     * Serializza il {@code message}, precedendolo con la sua lunghezza, in un {@link OutputStream}.
     * @return la dimensione del messaggio
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessagePacker with the provided buffer
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer);

        // Serialize the message using the schema
        schema.write(packer, message);

        // Get the serialized message as a byte array
        byte[] serializedMessage = packer.toByteArray();

        // Write the length of the message as a varint
        MessagePacker lengthPacker = MessagePack.newDefaultPacker(out);
        lengthPacker.packInt(serializedMessage.length);
        lengthPacker.flush();

        // Write the serialized message to the output stream
        out.write(serializedMessage);

        // Return the total size of the message (length + serialized message)
        return serializedMessage.length + MessagePack.newDefaultBufferPacker().packInt(serializedMessage.length).toByteArray().length;
    }
}