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

    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessageBufferPacker to serialize the message
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer);

        // Serialize the message using the provided schema
        schema.write(packer, message);

        // Get the serialized message as a byte array
        byte[] serializedMessage = packer.toByteArray();

        // Write the length of the serialized message as a varint
        int length = serializedMessage.length;
        MessagePacker lengthPacker = MessagePack.newDefaultPacker(out);
        lengthPacker.packInt(length);
        lengthPacker.flush();

        // Write the serialized message to the output stream
        out.write(serializedMessage);

        // Return the total size of the message (length + serialized message)
        return length + serializedMessage.length;
    }
}