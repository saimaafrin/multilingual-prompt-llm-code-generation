import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Attribute;

public class CustomClassReader extends ClassReader {
    
    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Legge un valore short firmato in questo {@link ClassReader}. <i>Questo metodo è destinato alle sottoclassi di {@link Attribute} e normalmente non è necessario per i generatori di classi o gli adattatori.</i>
     * @param offset l'offset di partenza del valore da leggere in questo {@link ClassReader}.
     * @return il valore letto.
     */
    public short readShort(final int offset) {
        byte[] classFileBuffer = this.b;
        return (short)((classFileBuffer[offset] & 0xFF) << 8 | (classFileBuffer[offset + 1] & 0xFF));
    }
}