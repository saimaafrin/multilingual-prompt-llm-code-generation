import java.io.IOException;
import java.io.OutputStream;
import org.objenesis.strategy.StdInstantiatorStrategy;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class DelimitedMessageWriter {

    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @return the size of the message
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        if (out == null || message == null || schema == null || buffer == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }

        // Serialize the message to a byte array
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a varint
        int length = data.length;
        writeVarint(out, length);

        // Write the serialized message
        out.write(data);

        // Return the total size of the message (varint length + data length)
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