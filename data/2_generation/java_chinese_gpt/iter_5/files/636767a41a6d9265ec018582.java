import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageWriter {

    /**
     * 将 {@code message} 序列化，并在前面加上其长度，写入 {@link OutputStream}。
     * @return 消息的大小
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message using the provided schema
        int size = schema.getSerializedSize(message);
        
        // Write the size of the message to the output stream
        out.write(intToByteArray(size));
        
        // Write the actual message to the output stream
        schema.writeTo(message, out, buffer);
        
        return size;
    }

    private static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value >>> 24),
            (byte) (value >>> 16),
            (byte) (value >>> 8),
            (byte) value
        };
    }
}