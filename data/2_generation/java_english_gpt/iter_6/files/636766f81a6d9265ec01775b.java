import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * Reads a signed long value in this {@link ClassReader}. <i>This method is intended for  {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return ByteBuffer.wrap(data, offset, 8).getLong();
    }

    public static void main(String[] args) {
        // Example usage
        byte[] exampleData = new byte[16];
        ByteBuffer.wrap(exampleData).putLong(0, 1234567890123456789L);
        
        ClassReader reader = new ClassReader(exampleData);
        long value = reader.readLong(0);
        System.out.println("Read long value: " + value);
    }
}