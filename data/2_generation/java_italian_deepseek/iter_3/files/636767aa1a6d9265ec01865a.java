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
     * Scrive il contenuto del {@link LinkedBuffer} nel {@link DataOutput}.
     * @param out Il DataOutput su cui scrivere i dati.
     * @param node Il nodo iniziale del LinkedBuffer.
     * @return la dimensione totale del contenuto del buffer.
     * @throws IOException Se si verifica un errore di I/O durante la scrittura.
     */
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