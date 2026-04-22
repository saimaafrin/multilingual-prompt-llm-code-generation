import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.buffer.OutputStreamBufferOutput;
import org.msgpack.core.schema.Schema;

public class MessageSerializer {

    /**
     * {@code message} को इसके आकार के साथ प्रारंभ करते हुए {@link OutputStream} में सीरियलाइज़ करता है।
     * @return संदेश का आकार
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        MessageBufferOutput output = new OutputStreamBufferOutput(out);
        MessagePacker packer = MessagePack.newDefaultPacker(output);

        // Write the size of the message first
        byte[] serializedMessage = serializeMessage(message, schema, buffer);
        packer.packInt(serializedMessage.length);

        // Write the serialized message
        packer.writePayload(serializedMessage);
        packer.flush();

        return serializedMessage.length;
    }

    private static <T> byte[] serializeMessage(T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer);
        schema.write(packer, message);
        packer.flush();
        return packer.toByteArray();
    }
}