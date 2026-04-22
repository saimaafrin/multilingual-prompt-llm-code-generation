import java.io.DataOutput;
import java.io.IOException;

public class BufferWriter {
    /**
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @return el tamaño total del contenido del búfer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        if (out == null || node == null) {
            return 0;
        }

        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            byte[] buffer = current.getBuffer();
            int offset = current.getOffset();
            int size = current.getSize();

            if (buffer != null && size > 0) {
                out.write(buffer, offset, size);
                totalSize += size;
            }

            current = current.getNext();
        }

        return totalSize;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int offset;
    private int size;
    private LinkedBuffer next;

    public byte[] getBuffer() {
        return buffer;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public LinkedBuffer getNext() {
        return next;
    }
}