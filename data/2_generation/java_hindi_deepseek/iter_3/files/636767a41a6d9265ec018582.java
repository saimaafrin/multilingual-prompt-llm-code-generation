import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.schema.Schema;

public class MessageSerializer {

    /**
     * {@code message} को इसके आकार के साथ प्रारंभ करते हुए {@link OutputStream} में सीरियलाइज़ करता है।
     * @return संदेश का आकार
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker(buffer);
        schema.write(packer, message);
        int size = packer.getBufferSize();
        MessageBufferOutput output = MessagePack.newDefaultBufferOutput(out);
        output.writeBuffer(MessageBuffer.wrap(packer.toByteArray()));
        output.flush();
        return size;
    }
}