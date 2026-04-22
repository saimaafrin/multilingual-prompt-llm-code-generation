import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.io.DatumWriter;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;

public class SerializationUtil {

    /**
     * 将 {@code message} 序列化，并在前面加上其长度，写入 {@link OutputStream}。
     * @return 消息的大小
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message using Protobuf
        byte[] data = ProtobufIOUtil.toByteArray(message, schema, buffer);

        // Write the length of the message as a varint
        int length = data.length;
        writeVarint(out, length);

        // Write the serialized message
        out.write(data);

        // Return the total size of the message (length + data)
        return length + computeVarintSize(length);
    }

    private static void writeVarint(OutputStream out, int value) throws IOException {
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

    private static int computeVarintSize(int value) {
        int size = 0;
        while (true) {
            if ((value & ~0x7F) == 0) {
                size++;
                return size;
            } else {
                size++;
                value >>>= 7;
            }
        }
    }
}