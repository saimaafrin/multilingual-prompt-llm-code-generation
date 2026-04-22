import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer buffer;

    public ClassReader(byte[] data) {
        this.buffer = ByteBuffer.wrap(data);
    }

    /** 
     * Reads a signed long value in this  {@link ClassReader}. <i>This method is intended for  {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public long readLong(final int offset) {
        buffer.position(offset);
        return buffer.getLong();
    }

    public static void main(String[] args) {
        // Example usage
        byte[] data = new byte[16];
        ByteBuffer.wrap(data).putLong(0, 1234567890123456789L);
        ClassReader classReader = new ClassReader(data);
        long value = classReader.readLong(0);
        System.out.println("Read long value: " + value);
    }
}