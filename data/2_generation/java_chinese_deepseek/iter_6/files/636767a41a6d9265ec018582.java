import java.io.IOException;
import java.io.OutputStream;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.LinkedBuffer;
import org.msgpack.schema.Schema;

public class DelimitedMessageWriter {

    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a MessagePacker with the provided buffer
        MessagePacker packer = MessagePack.newDefaultPacker(buffer);

        // Serialize the message using the provided schema
        schema.write(packer, message);

        // Flush the packer to ensure all data is written to the buffer
        packer.flush();

        // Get the size of the serialized message
        int messageSize = packer.getTotalWrittenBytes();

        // Write the message size as a varint (variable-length integer) to the output stream
        writeVarint(out, messageSize);

        // Write the serialized message to the output stream
        out.write(buffer.array(), 0, messageSize);

        // Return the total size of the message including the size prefix
        return messageSize + getVarintSize(messageSize);
    }

    private static void writeVarint(OutputStream out, int value) throws IOException {
        while (true) {
            if ((value & ~0x7F) == 0) {
                out.write(value);
                return;
            } else {
                out.write((value & 0x7F) | 0x80);
                value >>>= 7;
            }
        }
    }

    private static int getVarintSize(int value) {
        int size = 0;
        while (true) {
            if ((value & ~0x7F) == 0) {
                size++;
                return size;
            } else {
                size++;
                value >>>= 7;
            }
        }
    }
}