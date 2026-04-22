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
        byte[] messageBytes = schema.encode(message, buffer);
        
        // Get the length of the message
        int length = messageBytes.length;
        
        // Write the length as a varint
        out.write(intToVarint(length));
        
        // Write the message bytes
        out.write(messageBytes);
        
        return length;
    }

    private static byte[] intToVarint(int value) {
        // Convert integer to varint format
        byte[] buffer = new byte[5];
        int i = 0;
        while ((value & ~0x7F) != 0) {
            buffer[i++] = (byte) ((value & 0x7F) | 0x80);
            value >>>= 7;
        }
        buffer[i] = (byte) (value & 0x7F);
        byte[] result = new byte[i + 1];
        System.arraycopy(buffer, 0, result, 0, i + 1);
        return result;
    }
}