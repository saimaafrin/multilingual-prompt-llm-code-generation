import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * 在此 {@link ClassReader} 中读取一个有符号短整型值。<i>此方法旨在供 {@link Attribute} 子类使用，通常不用于类生成器或适配器。</i>
     * @param offset 此 {@link ClassReader} 中要读取的值的起始偏移量。
     * @return 读取的值。
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Offset out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 2);
        return buffer.getShort();
    }
}