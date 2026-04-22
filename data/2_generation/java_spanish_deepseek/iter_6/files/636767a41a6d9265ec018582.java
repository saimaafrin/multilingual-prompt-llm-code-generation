import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.util.LinkedBuffer;

public class DelimitedWriter {

    /**
     * Serializa el {@code message}, precedido por su longitud, en un {@link OutputStream}.
     * @return el tamaño del mensaje
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Create a DatumWriter for the given schema
        DatumWriter<T> datumWriter = new SpecificDatumWriter<>(schema);

        // Create an Encoder that writes to the OutputStream
        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);

        // Write the length of the message first
        int length = buffer.getLength();
        out.write((length >> 24) & 0xFF);
        out.write((length >> 16) & 0xFF);
        out.write((length >> 8) & 0xFF);
        out.write(length & 0xFF);

        // Write the message using the DatumWriter
        datumWriter.write(message, encoder);
        encoder.flush();

        // Return the total size of the message (length + message)
        return 4 + length;
    }
}