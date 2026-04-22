import java.io.DataOutput;
import java.io.IOException;

class LinkedBuffer {
    // Assuming LinkedBuffer has a method to get the data and the next node
    byte[] data;
    LinkedBuffer next;

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

public class BufferWriter {
    /** 
     * Scrive il contenuto del {@link LinkedBuffer} nel {@link DataOutput}.
     * @return la dimensione totale del contenuto del buffer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            byte[] bufferData = current.getData();
            out.write(bufferData);
            totalSize += bufferData.length;
            current = current.getNext();
        }

        return totalSize;
    }
}