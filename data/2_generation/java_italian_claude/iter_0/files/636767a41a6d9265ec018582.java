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
        // Create protobuf output using the buffer
        final ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Serialize the message to get its size
        schema.writeTo(output, message);
        
        // Get the size of the serialized message
        int size = output.getSize();
        
        // Write the size as a varint to the output stream
        while ((size & ~0x7F) != 0) {
            out.write((size & 0x7F) | 0x80);
            size >>>= 7;
        }
        out.write(size);
        
        // Write the actual message
        LinkedBuffer.writeTo(out, buffer);
        
        // Return the total size of the message
        return output.getSize();
    }
}