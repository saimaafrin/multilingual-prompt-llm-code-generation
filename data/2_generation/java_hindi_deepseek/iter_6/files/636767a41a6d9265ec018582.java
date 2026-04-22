import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.schema.Schema;

public class MessageSerializer {

    /**
     * {@code message} को इसके आकार के साथ प्रारंभ करते हुए {@link OutputStream} में सीरियलाइज़ करता है।
     * @return संदेश का आकार
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        try (MessagePacker packer = MessagePack.newDefaultPacker(out)) {
            // Serialize the message using the provided schema
            schema.write(packer, message);
            packer.flush();
            return packer.getTotalWrittenBytes();
        }
    }
}