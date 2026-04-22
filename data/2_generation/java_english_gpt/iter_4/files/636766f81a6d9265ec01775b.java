import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /** 
     * Reads a signed long value in this {@link ClassReader}. <i>This method is intended for {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + Long.BYTES > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, Long.BYTES);
        return buffer.getLong();
    }
}