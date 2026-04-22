import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Attribute;

public class CustomClassReader extends ClassReader {
    
    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Legge un valore long firmato in questo {@link ClassReader}. <i>Questo metodo è destinato alle sottoclassi di {@link Attribute} e normalmente non è necessario per i generatori di classi o adattatori.</i>
     * @param offset l'offset di partenza del valore da leggere in questo {@link ClassReader}.
     * @return il valore letto.
     */
    public long readLong(final int offset) {
        byte[] b = this.b;
        return (((long)b[offset] & 0xFF) << 56)
            | (((long)b[offset + 1] & 0xFF) << 48)
            | (((long)b[offset + 2] & 0xFF) << 40) 
            | (((long)b[offset + 3] & 0xFF) << 32)
            | (((long)b[offset + 4] & 0xFF) << 24)
            | (((long)b[offset + 5] & 0xFF) << 16)
            | (((long)b[offset + 6] & 0xFF) << 8)
            | ((long)b[offset + 7] & 0xFF);
    }
}