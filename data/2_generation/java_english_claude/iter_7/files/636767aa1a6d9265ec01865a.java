import java.io.DataOutput;
import java.io.IOException;

public class BufferWriter {
    /**
     * Writes the contents of the LinkedBuffer into the DataOutput.
     * @return the total content size of the buffer.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        if (out == null || node == null) {
            return 0;
        }

        int size = 0;
        LinkedBuffer current = node;

        while (current != null) {
            byte[] buffer = current.getBuffer();
            int offset = current.getOffset();
            int length = current.getLength();

            if (buffer != null && length > 0) {
                out.write(buffer, offset, length);
                size += length;
            }
            
            current = current.next();
        }

        return size;
    }
}

// Helper class to represent a LinkedBuffer node
class LinkedBuffer {
    private byte[] buffer;
    private int offset;
    private int length;
    private LinkedBuffer next;

    public byte[] getBuffer() {
        return buffer;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public LinkedBuffer next() {
        return next;
    }
}