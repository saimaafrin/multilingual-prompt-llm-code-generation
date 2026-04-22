import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.schema.Schema;

public class MessageSerializer {

    /**
     * {@code message} को इसके आकार के साथ प्रारंभ करते हुए {@link OutputStream} में सीरियलाइज़ करता है।
     * @return संदेश का आकार
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer);
        schema.write(packer, message);
        packer.flush();

        MessageBuffer packedBuffer = packer.toMessageBuffer();
        int size = packedBuffer.size();

        // Write the size of the message first
        MessagePacker sizePacker = MessagePack.newDefaultPacker(out);
        sizePacker.packInt(size);
        sizePacker.flush();

        // Write the actual message
        out.write(packedBuffer.array(), packedBuffer.arrayOffset(), size);

        return size;
    }
}