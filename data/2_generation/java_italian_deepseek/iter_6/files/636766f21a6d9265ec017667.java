import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Legge un valore short firmato in questo {@link ClassReader}. <i>Questo metodo è destinato alle sottoclassi di {@link Attribute} e normalmente non è necessario per i generatori di classi o gli adattatori.</i>
     * @param offset l'offset di partenza del valore da leggere in questo {@link ClassReader}.
     * @return il valore letto.
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Offset out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 2);
        return buffer.getShort();
    }
}