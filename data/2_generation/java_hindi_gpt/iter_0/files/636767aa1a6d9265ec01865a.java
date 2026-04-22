import java.io.DataOutput;
import java.io.IOException;

public class LinkedBufferWriter {

    /**
     * {@link LinkedBuffer} की सामग्री को {@link DataOutput} में लिखता है।
     * @return बफर का कुल सामग्री आकार।
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        while (node != null) {
            // Assuming LinkedBuffer has a method to get its data and size
            byte[] data = node.getData();
            int size = data.length;
            out.write(data);
            totalSize += size;
            node = node.getNext(); // Assuming LinkedBuffer has a method to get the next node
        }
        return totalSize;
    }
}

class LinkedBuffer {
    private byte[] data;
    private LinkedBuffer next;

    public LinkedBuffer(byte[] data) {
        this.data = data;
        this.next = null;
    }

    public byte[] getData() {
        return data;
    }

    public LinkedBuffer getNext() {
        return next;
    }

    public void setNext(LinkedBuffer next) {
        this.next = next;
    }
}