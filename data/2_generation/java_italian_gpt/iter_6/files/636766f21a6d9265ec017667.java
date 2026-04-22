import java.io.IOException;

public class ClassReader {
    private final byte[] data;
    
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
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return (short) ((data[offset] << 8) | (data[offset + 1] & 0xFF));
    }
}