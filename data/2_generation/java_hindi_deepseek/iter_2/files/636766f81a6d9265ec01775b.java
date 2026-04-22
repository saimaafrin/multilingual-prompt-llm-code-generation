import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IllegalArgumentException("Offset is out of bounds");
        }

        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 8);
        return buffer.getLong();
    }
}