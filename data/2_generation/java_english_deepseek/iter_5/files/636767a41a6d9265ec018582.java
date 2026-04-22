import java.io.IOException;
import java.io.OutputStream;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;

public class DelimitedMessageWriter {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @param out the output stream to write the message to
     * @param message the message to serialize
     * @param schema the schema for the message
     * @param buffer the buffer to use for serialization
     * @return the size of the message
     * @throws IOException if an I/O error occurs
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a varint
        int length = data.length;
        writeVarint(out, length);

        // Write the serialized message
        out.write(data);

        // Return the total size of the message (varint length + message size)
        return data.length + computeVarintSize(length);
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

    private static int computeVarintSize(int value) {
        if ((value & (0xffffffff <<  7)) == 0) return 1;
        if ((value & (0xffffffff << 14)) == 0) return 2;
        if ((value & (0xffffffff << 21)) == 0) return 3;
        if ((value & (0xffffffff << 28)) == 0) return 4;
        return 5;
    }
}