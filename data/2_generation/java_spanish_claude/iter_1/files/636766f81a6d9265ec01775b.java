import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Attribute;

public class CustomClassReader extends ClassReader {

    public CustomClassReader(byte[] classFile) {
        super(classFile);
    }

    /**
     * Lee un valor long con signo en este {@link ClassReader}. <i>Este método está destinado a subclases de {@link Attribute},
     * y normalmente no es necesario para generadores de clases o adaptadores.</i>
     * @param offset el desplazamiento inicial del valor a leer en este {@link ClassReader}.
     * @return el valor leído.
     */
    public long readLong(final int offset) {
        byte[] classFileBuffer = this.b;
        return (((long)classFileBuffer[offset] & 0xFF) << 56)
            | (((long)classFileBuffer[offset + 1] & 0xFF) << 48)
            | (((long)classFileBuffer[offset + 2] & 0xFF) << 40)
            | (((long)classFileBuffer[offset + 3] & 0xFF) << 32)
            | (((long)classFileBuffer[offset + 4] & 0xFF) << 24)
            | (((long)classFileBuffer[offset + 5] & 0xFF) << 16)
            | (((long)classFileBuffer[offset + 6] & 0xFF) << 8)
            | ((long)classFileBuffer[offset + 7] & 0xFF);
    }
}