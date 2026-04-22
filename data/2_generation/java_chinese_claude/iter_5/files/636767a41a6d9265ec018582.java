import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.ProtobufOutput;
import java.io.IOException;
import java.io.OutputStream;

public class MessageWriter {
    
    /**
     * 将 {@code message} 序列化，并在前面加上其长度，写入 {@link OutputStream}。
     * @return 消息的大小
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create ProtobufOutput with the provided buffer
        ProtobufOutput output = new ProtobufOutput(buffer);
        
        // Serialize the message using schema
        schema.writeTo(output, message);
        
        // Get the serialized bytes
        byte[] bytes = output.toByteArray();
        
        // Write the size of the message as a varint
        writeRawVarint32(out, bytes.length);
        
        // Write the actual message bytes
        out.write(bytes);
        
        // Return total size (varint size + message size)
        return bytes.length + computeRawVarint32Size(bytes.length);
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
    
    private static int computeRawVarint32Size(int value) {
        if ((value & (0xffffffff << 7)) == 0) return 1;
        if ((value & (0xffffffff << 14)) == 0) return 2;
        if ((value & (0xffffffff << 21)) == 0) return 3;
        if ((value & (0xffffffff << 28)) == 0) return 4;
        return 5;
    }
}