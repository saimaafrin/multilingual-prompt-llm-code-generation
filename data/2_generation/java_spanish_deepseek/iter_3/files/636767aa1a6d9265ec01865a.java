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
            byte[] data = current.getData();
            out.write(data);
            totalSize += data.length;
            current = current.getNext();
        }

        return totalSize;
    }
}