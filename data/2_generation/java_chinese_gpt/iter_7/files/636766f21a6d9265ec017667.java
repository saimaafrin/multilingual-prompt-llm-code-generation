import java.io.IOException;

public class ClassReader {
    private final byte[] data;

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
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return (short) ((data[offset] << 8) | (data[offset + 1] & 0xFF));
    }

    public static void main(String[] args) {
        // Example usage
        byte[] exampleData = {0x01, 0x02, 0x03, 0x04};
        ClassReader reader = new ClassReader(exampleData);
        short value = reader.readShort(0);
        System.out.println("Read short value: " + value);
    }
}