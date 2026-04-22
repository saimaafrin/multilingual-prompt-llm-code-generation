import java.io.DataOutput;
import java.io.IOException;

class LinkedBuffer {
    byte[] data;
    LinkedBuffer next;

    public LinkedBuffer(byte[] data) {
        this.data = data;
        this.next = null;
    }
}

public class BufferWriter {

    /** 
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @return el tamaño total del contenido del búfer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            out.write(current.data);
            totalSize += current.data.length;
            current = current.next;
        }

        return totalSize;
    }
}