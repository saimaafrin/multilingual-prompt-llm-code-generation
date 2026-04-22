import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.io.DatumWriter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;

public class DelimitedMessageWriter {

    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a ByteBuf to hold the serialized message
        ByteBuf byteBuf = Unpooled.buffer();
        ByteBufOutputStream byteBufOutputStream = new ByteBufOutputStream(byteBuf);

        // Create an Avro encoder
        Encoder encoder = EncoderFactory.get().binaryEncoder(byteBufOutputStream, null);

        // Create a DatumWriter for the given schema
        DatumWriter<T> datumWriter = new SpecificDatumWriter<>(schema);

        // Serialize the message
        datumWriter.write(message, encoder);
        encoder.flush();

        // Get the length of the serialized message
        int messageLength = byteBuf.readableBytes();

        // Write the length of the message as a varint
        writeVarint(out, messageLength);

        // Write the serialized message to the output stream
        byteBuf.readBytes(out, messageLength);

        // Return the total size of the message (length + serialized message)
        return messageLength + computeVarintSize(messageLength);
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