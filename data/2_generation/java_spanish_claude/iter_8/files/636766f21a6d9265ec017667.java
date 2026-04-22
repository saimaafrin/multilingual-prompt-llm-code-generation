import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Attribute;

public class CustomClassReader extends ClassReader {

    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Lee un valor corto con signo en este {@link ClassReader}. <i>Este método está destinado a subclases de {@link Attribute},
     * y normalmente no es necesario para generadores de clases o adaptadores.</i>
     * @param offset el desplazamiento inicial del valor a leer en este {@link ClassReader}.
     * @return el valor leído.
     */
    public short readShort(final int offset) {
        byte[] classFileBuffer = this.b;
        return (short) ((classFileBuffer[offset] << 8) | (classFileBuffer[offset + 1] & 0xFF));
    }
}