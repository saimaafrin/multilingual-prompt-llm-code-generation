import java.io.DataOutput;
import java.io.IOException;

class LinkedBuffer {
    // Assuming LinkedBuffer has a method to get its content and size
    private byte[] content;
    private LinkedBuffer next;

    public LinkedBuffer(byte[] content) {
        this.content = content;
        this.next = null;
    }

    public byte[] getContent() {
        return content;
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
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @return el tamaño total del contenido del búfer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            byte[] content = current.getContent();
            out.write(content);
            totalSize += content.length;
            current = current.getNext();
        }

        return totalSize;
    }
}