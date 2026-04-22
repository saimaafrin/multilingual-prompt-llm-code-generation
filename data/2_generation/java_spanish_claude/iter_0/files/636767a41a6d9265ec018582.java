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
        ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Serialize the message to get its size
        schema.writeTo(output, message);
        
        // Get the serialized size
        int size = output.getSize();
        
        // Write the size as a varint to the output stream
        while ((size & ~0x7F) != 0) {
            out.write((size & 0x7F) | 0x80);
            size >>>= 7;
        }
        out.write(size);
        
        // Write the actual message
        LinkedBuffer.writeTo(out, buffer);
        
        // Clear the buffer
        buffer.clear();
        
        return output.getSize();
    }
}