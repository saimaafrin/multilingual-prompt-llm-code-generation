import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageSerializer {

    /** 
     * Serializes the  {@code message}, prefixed with its length, into an  {@link OutputStream}.
     * @return the size of the message
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        byte[] data = schema.encode(message, buffer);
        int size = data.length;

        // Write the size of the message
        out.write(intToByteArray(size));

        // Write the message itself
        out.write(data);

        return size;
    }

    private static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value >>> 24),
            (byte) (value >>> 16),
            (byte) (value >>> 8),
            (byte) value
        };
    }
}