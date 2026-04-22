import java.io.IOException;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Lee un valor long con signo en este {@link ClassReader}. <i>Este método está destinado a subclases de {@link Attribute},y normalmente no es necesario para generadores de clases o adaptadores.</i>
     * @param offset el desplazamiento inicial del valor a leer en este {@link ClassReader}.
     * @return el valor leído.
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return ((long) (data[offset] & 0xFF) << 56) |
               ((long) (data[offset + 1] & 0xFF) << 48) |
               ((long) (data[offset + 2] & 0xFF) << 40) |
               ((long) (data[offset + 3] & 0xFF) << 32) |
               ((long) (data[offset + 4] & 0xFF) << 24) |
               ((data[offset + 5] & 0xFF) << 16) |
               ((data[offset + 6] & 0xFF) << 8) |
               (data[offset + 7] & 0xFF);
    }
}