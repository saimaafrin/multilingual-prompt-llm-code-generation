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
        byte[] messageBytes = schema.encode(message, buffer);
        
        // Get the length of the message
        int length = messageBytes.length;
        
        // Write the length of the message as a varint
        writeVarint(out, length);
        
        // Write the message bytes to the output stream
        out.write(messageBytes);
        
        // Return the total size of the message
        return length + getVarintSize(length);
    }

    private static void writeVarint(OutputStream out, int value) throws IOException {
        while ((value & ~0x7F) != 0) {
            out.write((value & 0x7F) | 0x80);
            value >>>= 7;
        }
        out.write(value);
    }

    private static int getVarintSize(int value) {
        int size = 0;
        while ((value & ~0x7F) != 0) {
            size++;
            value >>>= 7;
        }
        return size + 1; // for the last byte
    }
}