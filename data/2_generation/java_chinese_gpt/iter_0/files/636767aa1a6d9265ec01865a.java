import java.io.DataOutput;
import java.io.IOException;

public class LinkedBufferWriter {

    /**
     * 将 {@link LinkedBuffer} 的内容写入 {@link DataOutput}。
     * @return 缓冲区的总内容大小。
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            byte[] data = current.getData(); // Assuming LinkedBuffer has a method to get its data
            out.write(data);
            totalSize += data.length;
            current = current.getNext(); // Assuming LinkedBuffer has a method to get the next node
        }

        return totalSize;
    }
}

class LinkedBuffer {
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
}