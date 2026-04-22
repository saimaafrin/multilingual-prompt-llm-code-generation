import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.ProtobufOutput;
import java.io.IOException;
import java.io.OutputStream;

public class MessageSerializer {

    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create ProtobufOutput with the provided buffer
        ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Write message to buffer using schema
        schema.writeTo(output, message);
        
        // Get size of serialized message
        int size = output.getSize();
        
        // Write the size as a varint prefix
        while ((size & ~0x7F) != 0) {
            out.write((size & 0x7F) | 0x80);
            size >>>= 7;
        }
        out.write(size);
        
        // Write the actual message bytes
        LinkedBuffer.writeTo(out, buffer);
        
        // Return total size
        return output.getSize();
    }
}