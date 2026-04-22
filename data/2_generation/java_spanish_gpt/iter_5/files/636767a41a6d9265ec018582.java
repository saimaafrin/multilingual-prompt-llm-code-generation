import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageSerializer {

    /** 
     * Serializa el {@code message},precedido por su longitud, en un {@link OutputStream}.
     * @return el tamaño del mensaje
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        int size = schema.getSerializedSize(message);
        byte[] bytes = new byte[size];
        schema.writeTo(message, bytes, 0, size);
        
        // Write the length of the message
        out.write(intToByteArray(size));
        
        // Write the message itself
        out.write(bytes);
        
        return size;
    }

    private static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value & 0xFF),
            (byte) ((value >> 8) & 0xFF),
            (byte) ((value >> 16) & 0xFF),
            (byte) ((value >> 24) & 0xFF)
        };
    }
}