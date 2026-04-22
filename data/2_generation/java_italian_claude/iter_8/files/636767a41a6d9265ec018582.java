import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.ProtobufOutput;
import java.io.IOException;
import java.io.OutputStream;

public class MessageSerializer {

    /**
     * Serializza il {@code message}, precedendolo con la sua lunghezza, in un {@link OutputStream}.
     * @return la dimensione del messaggio
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create ProtobufOutput for serialization
        ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Serialize the message
        schema.writeTo(output, message);
        
        // Get the serialized bytes
        byte[] bytes = output.toByteArray();
        
        // Write the message size as a varint
        writeRawVarint32(out, bytes.length);
        
        // Write the actual message
        out.write(bytes);
        
        // Return total message size
        return bytes.length;
    }
    
    private static void writeRawVarint32(OutputStream out, int value) throws IOException {
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
}