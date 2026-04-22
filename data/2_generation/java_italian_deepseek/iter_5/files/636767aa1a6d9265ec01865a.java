import java.io.DataOutput;
import java.io.IOException;

public class LinkedBuffer {

    private byte[] data;
    private LinkedBuffer next;

    public LinkedBuffer(byte[] data, LinkedBuffer next) {
        this.data = data;
        this.next = next;
    }

    public byte[] getData() {
        return data;
    }

    public LinkedBuffer getNext() {
        return next;
    }

    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        while (node != null) {
            byte[] data = node.getData();
            out.write(data);
            totalSize += data.length;
            node = node.getNext();
        }
        return totalSize;
    }
}