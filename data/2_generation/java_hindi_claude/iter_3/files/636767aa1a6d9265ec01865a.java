import java.io.DataOutput;
import java.io.IOException;

public class LinkedBuffer {
    private byte[] buffer;
    private LinkedBuffer next;
    private int offset;
    private int size;

    public int writeTo(final DataOutput out) throws IOException {
        int totalSize = 0;
        LinkedBuffer node = this;
        
        while (node != null && node.size > 0) {
            out.write(node.buffer, node.offset, node.size);
            totalSize += node.size;
            node = node.next;
        }
        
        return totalSize;
    }
}