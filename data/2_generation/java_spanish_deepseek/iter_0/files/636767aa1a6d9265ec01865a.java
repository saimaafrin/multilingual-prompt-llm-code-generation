import java.io.DataOutput;
import java.io.IOException;

public class LinkedBufferWriter {

    /**
     * Escribe el contenido del {@link LinkedBuffer} en el {@link DataOutput}.
     * @param out El DataOutput donde se escribirá el contenido.
     * @param node El nodo inicial del LinkedBuffer.
     * @return el tamaño total del contenido del búfer.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static int writeTo(final DataOutput out, LinkedBuffer node) throws IOException {
        int totalSize = 0;
        LinkedBuffer current = node;

        while (current != null) {
            out.write(current.getBuffer(), current.getOffset(), current.getLength());
            totalSize += current.getLength();
            current = current.getNext();
        }

        return totalSize;
    }

    // Clase LinkedBuffer (asumida)
    public static class LinkedBuffer {
        private byte[] buffer;
        private int offset;
        private int length;
        private LinkedBuffer next;

        public LinkedBuffer(byte[] buffer, int offset, int length, LinkedBuffer next) {
            this.buffer = buffer;
            this.offset = offset;
            this.length = length;
            this.next = next;
        }

        public byte[] getBuffer() {
            return buffer;
        }

        public int getOffset() {
            return offset;
        }

        public int getLength() {
            return length;
        }

        public LinkedBuffer getNext() {
            return next;
        }
    }
}