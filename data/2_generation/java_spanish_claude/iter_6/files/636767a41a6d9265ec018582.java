import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.ProtobufOutput;
import java.io.IOException;
import java.io.OutputStream;

public class MessageSerializer {

    /**
     * Serializa el {@code message},precedido por su longitud, en un {@link OutputStream}.
     * @return el tamaño del mensaje
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create protobuf output with the buffer
        final ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Serialize the message
        schema.writeTo(output, message);
        
        // Get the size of serialized message
        int size = output.getSize();
        
        // Write the size as a varint
        while ((size & ~0x7F) != 0) {
            out.write((size & 0x7F) | 0x80);
            size >>>= 7;
        }
        out.write(size);
        
        // Write the actual message
        LinkedBuffer.writeTo(out, buffer);
        
        // Return total size
        return output.getSize();
    }
}