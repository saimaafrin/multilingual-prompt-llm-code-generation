public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /** 
     * Reads a signed short value in this  {@link ClassReader}. <i>This method is intended for  {@link Attribute} sub classes, and is normally not needed by class generators or adapters.</i>
     * @param offset the start offset of the value to be read in this {@link ClassReader}.
     * @return the read value.
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return (short) ((data[offset] << 8) | (data[offset + 1] & 0xFF));
    }

    public static void main(String[] args) {
        byte[] exampleData = {0x00, 0x01, 0x02, 0x03, 0x04};
        ClassReader reader = new ClassReader(exampleData);
        short value = reader.readShort(0);
        System.out.println("Read short value: " + value);
    }
}