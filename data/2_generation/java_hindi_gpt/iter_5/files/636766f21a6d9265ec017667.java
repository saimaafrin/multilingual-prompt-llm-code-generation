public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /** 
     * इस {@link ClassReader} में एक साइन किया हुआ शॉर्ट मान पढ़ता है। <i>यह विधि {@link Attribute} उप श्रेणियों के लिए अभिप्रेत है, और सामान्यतः क्लास जनरेटर या एडाप्टर्स द्वारा आवश्यक नहीं होती।</i>
     * @param offset इस {@link ClassReader} में पढ़े जाने वाले मान का प्रारंभिक ऑफसेट।
     * @return पढ़ा गया मान।
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > data.length) {
            throw new IndexOutOfBoundsException("Invalid offset: " + offset);
        }
        return (short) ((data[offset] << 8) | (data[offset + 1] & 0xFF));
    }

    public static void main(String[] args) {
        byte[] exampleData = {0x01, 0x02, 0x03, 0x04};
        ClassReader reader = new ClassReader(exampleData);
        short value = reader.readShort(0);
        System.out.println("Read short value: " + value);
    }
}