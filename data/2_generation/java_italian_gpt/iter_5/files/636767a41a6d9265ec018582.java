import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageSerializer {

    /** 
     * Serializza il {@code message}, precedendolo con la sua lunghezza, in un {@link OutputStream}.
     * @return la dimensione del messaggio
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        int size = schema.getSerializedSize(message);
        byte[] serializedMessage = new byte[size];
        schema.writeTo(message, serializedMessage, buffer);

        // Write the size of the message
        out.write(intToByteArray(size));
        // Write the serialized message
        out.write(serializedMessage);
        
        return size;
    }

    private static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };
    }
}