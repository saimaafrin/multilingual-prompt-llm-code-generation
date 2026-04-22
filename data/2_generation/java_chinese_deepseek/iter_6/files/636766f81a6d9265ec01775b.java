import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * 在此 {@link ClassReader} 中读取一个有符号的长整型值。<i>此方法旨在用于 {@link Attribute} 子类，通常不用于类生成器或适配器。</i>
     * @param offset 要读取的值在此 {@link ClassReader} 中的起始偏移量。
     * @return 读取的值。
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 8);
        return buffer.getLong();
    }
}