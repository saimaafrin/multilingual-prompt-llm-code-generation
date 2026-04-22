import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.schema.Schema;

public class DelimitedMessageWriter {

    /**
     * Serializza il {@code message}, precedendolo con la sua lunghezza, in un {@link OutputStream}.
     * @return la dimensione del messaggio
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessagePacker with the provided buffer
        MessagePacker packer = MessagePack.newDefaultPacker(buffer);

        // Serialize the message using the schema
        schema.write(packer, message);

        // Flush the packer to ensure all data is written to the buffer
        packer.flush();

        // Get the size of the serialized message
        int messageSize = packer.getTotalWrittenBytes();

        // Write the message size as a varint to the output stream
        MessageBufferPacker sizePacker = MessagePack.newDefaultBufferPacker();
        sizePacker.packInt(messageSize);
        sizePacker.flush();
        out.write(sizePacker.toByteArray());

        // Write the serialized message to the output stream
        out.write(buffer.toByteArray());

        // Return the total size of the message (including the size prefix)
        return messageSize + sizePacker.getTotalWrittenBytes();
    }
}