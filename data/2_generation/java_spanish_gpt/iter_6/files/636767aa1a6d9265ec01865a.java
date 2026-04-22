import java.io.DataOutput;
import java.io.IOException;

class LinkedBuffer {
    // Assuming LinkedBuffer has a method to get its content as byte array
    byte[] getContent() {
        // Placeholder for actual implementation
        return new byte[0];
    }

    LinkedBuffer next; // Assuming LinkedBuffer has a reference to the next node
}

public class BufferWriter {

    /** 
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @return el tamaño total del contenido del búfer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;

        while (node != null) {
            byte[] content = node.getContent();
            out.write(content);
            totalSize += content.length;
            node = node.next; // Move to the next LinkedBuffer
        }

        return totalSize;
    }
}