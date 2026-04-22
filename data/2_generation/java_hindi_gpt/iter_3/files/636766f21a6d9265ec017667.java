public class ClassReader {
    
    private byte[] classData;

    public ClassReader(byte[] classData) {
        this.classData = classData;
    }

    /** 
     * इस {@link ClassReader} में एक साइन किया हुआ शॉर्ट मान पढ़ता है। <i>यह विधि {@link Attribute} उप श्रेणियों के लिए अभिप्रेत है, और सामान्यतः क्लास जनरेटर या एडाप्टर्स द्वारा आवश्यक नहीं होती।</i>
     * @param offset इस {@link ClassReader} में पढ़े जाने वाले मान का प्रारंभिक ऑफसेट।
     * @return पढ़ा गया मान।
     */
    public short readShort(final int offset) {
        if (offset < 0 || offset + 2 > classData.length) {
            throw new IndexOutOfBoundsException("Invalid offset: " + offset);
        }
        return (short) ((classData[offset] << 8) | (classData[offset + 1] & 0xFF));
    }

    public static void main(String[] args) {
        // Example usage
        byte[] data = {0x00, 0x01, 0x02, 0x03}; // Example byte array
        ClassReader reader = new ClassReader(data);
        short value = reader.readShort(0);
        System.out.println("Read short value: " + value);
    }
}