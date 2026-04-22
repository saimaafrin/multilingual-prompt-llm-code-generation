import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Lee un valor long con signo en este {@link ClassReader}. <i>Este método está destinado a subclases de {@link Attribute},
     * y normalmente no es necesario para generadores de clases o adaptadores.</i>
     * @param offset el desplazamiento inicial del valor a leer en este {@link ClassReader}.
     * @return el valor leído.
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IllegalArgumentException("Offset out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 8);
        return buffer.getLong();
    }
}