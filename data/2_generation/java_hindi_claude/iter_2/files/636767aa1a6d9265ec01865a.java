import java.io.DataOutput;
import java.io.IOException;

public class LinkedBuffer {
    private byte[] buffer;
    private LinkedBuffer next;
    private int offset;
    private int size;

    public int writeTo(DataOutput out) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = this;
        
        while (current != null) {
            if (current.size > 0) {
                out.write(current.buffer, current.offset, current.size);
                totalSize += current.size;
            }
            current = current.next;
        }
        
        return totalSize;
    }
}