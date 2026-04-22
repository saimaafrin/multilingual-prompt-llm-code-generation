import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Reads a signed short value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Offset out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 2);
        return buffer.getShort();
    }
}