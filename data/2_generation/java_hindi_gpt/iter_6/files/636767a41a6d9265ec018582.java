import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageSerializer {

    /** 
     * {@code message} को इसके आकार के साथ प्रारंभ करते हुए {@link OutputStream} में सीरियलाइज़ करता है।
     * @return संदेश का आकार
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        int size = schema.getSerializedSize(message);
        out.write(intToByteArray(size));
        schema.writeTo(out, message, buffer);
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