import java.io.DataOutput;
import java.io.IOException;

public class BufferWriter {
    /**
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @return el tamaño total del contenido del búfer.
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
    
    // LinkedBuffer class for compilation
    private static class LinkedBuffer {
        byte[] buffer;
        int start;
        int offset;
        LinkedBuffer next;
    }
}