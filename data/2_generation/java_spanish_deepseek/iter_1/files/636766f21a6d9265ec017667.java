import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Lee un valor corto con signo en este {@link ClassReader}. <i>Este método está destinado a subclases de {@link Attribute},y normalmente no es necesario para generadores de clases o adaptadores.</i>
     * @param offset el desplazamiento inicial del valor a leer en este {@link ClassReader}.
     * @return el valor leído.
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Offset out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 2);
        return buffer.getShort();
    }
}