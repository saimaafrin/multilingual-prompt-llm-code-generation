import java.io.DataOutput;
import java.io.IOException;

public class BufferWriter {
    /**
     * Scrive il contenuto del {@link LinkedBuffer} nel {@link DataOutput}.
     * @return la dimensione totale del contenuto del buffer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        
        while (node != null && node.buffer != null) {
            int size = node.offset - node.start;
            if (size > 0) {
                out.write(node.buffer, node.start, size);
                totalSize += size;
            }
            node = node.next;
        }
        
        return totalSize;
    }
}

// Helper class needed for compilation
class LinkedBuffer {
    byte[] buffer;
    int start;
    int offset; 
    LinkedBuffer next;
}