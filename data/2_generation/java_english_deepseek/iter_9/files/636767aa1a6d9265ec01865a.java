import java.io.DataOutput;
import java.io.IOException;

public class LinkedBuffer {

    private byte[] data;
    private LinkedBuffer next;

    public LinkedBuffer(byte[] data, LinkedBuffer next) {
        this.data = data;
        this.next = next;
    }

    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        while (node != null) {
            out.write(node.data);
            totalSize += node.data.length;
            node = node.next;
        }
        return totalSize;
    }
}