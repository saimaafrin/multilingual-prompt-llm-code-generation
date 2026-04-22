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

public class DelimitedMessageWriter {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @param out the output stream to write the message to
     * @param message the message to serialize
     * @param schema the schema to use for serialization
     * @param buffer the buffer to use for serialization
     * @return the size of the message
     * @throws IOException if an I/O error occurs
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessageBufferOutput from the OutputStream
        MessageBufferOutput bufferOutput = new OutputStreamBufferOutput(out);

        // Create a MessagePacker using the buffer
        MessagePacker packer = MessagePack.newDefaultPacker(bufferOutput);

        // Serialize the message using the schema
        schema.write(packer, message);

        // Flush the packer to ensure all data is written
        packer.flush();

        // Calculate the size of the message
        int size = packer.getTotalWrittenBytes();

        // Close the packer
        packer.close();

        return size;
    }
}