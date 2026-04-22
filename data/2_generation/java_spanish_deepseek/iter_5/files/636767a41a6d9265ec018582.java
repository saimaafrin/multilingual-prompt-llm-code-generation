import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.buffer.OutputStreamBufferOutput;
import org.msgpack.schema.Schema;

public class MessageSerializer {

    /**
     * Serializa el {@code message}, precedido por su longitud, en un {@link OutputStream}.
     * @return el tamaño del mensaje
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessageBufferOutput from the OutputStream
        MessageBufferOutput output = new OutputStreamBufferOutput(out);

        // Create a MessagePacker with the buffer
        MessagePacker packer = MessagePack.newDefaultPacker(output);

        // Write the length of the message first
        byte[] serializedMessage = schema.write(message, buffer);
        packer.packInt(serializedMessage.length);

        // Write the serialized message
        packer.writePayload(serializedMessage);

        // Flush the packer to ensure all data is written
        packer.flush();

        // Return the total size of the message (length + serialized message)
        return Integer.BYTES + serializedMessage.length;
    }
}