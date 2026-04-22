import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class MessageSerializer {
    
    /**
     * Serializes the {@code message}, prefixed with its length, into an {@link OutputStream}.
     * @param message The byte array message to serialize
     * @param out The output stream to write to
     * @return the size of the message
     * @throws IOException if an I/O error occurs
     */
    public static int serializeMessage(byte[] message, OutputStream out) throws IOException {
        // Write message length as 4 byte integer
        ByteBuffer lengthBuffer = ByteBuffer.allocate(4);
        lengthBuffer.putInt(message.length);
        out.write(lengthBuffer.array());
        
        // Write message content
        out.write(message);
        
        // Return total size (4 bytes for length + message size)
        return 4 + message.length;
    }
}