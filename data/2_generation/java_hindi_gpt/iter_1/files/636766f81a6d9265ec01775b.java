public class ClassReader {
    
    private byte[] data; // Assuming data is a byte array representing the class data

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /** 
     * इस {@link ClassReader} में एक साइन किया हुआ लॉन्ग मान पढ़ता है। <i>यह विधि {@link Attribute} उप श्रेणियों के लिए अभिप्रेत है, और सामान्यतः क्लास जनरेटर या एडाप्टर द्वारा आवश्यक नहीं होती।</i>
     * @param offset इस {@link ClassReader} में पढ़े जाने वाले मान का प्रारंभिक ऑफसेट।
     * @return पढ़ा गया मान।
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        return ((long) data[offset] << 56) |
               ((long) (data[offset + 1] & 255) << 48) |
               ((long) (data[offset + 2] & 255) << 40) |
               ((long) (data[offset + 3] & 255) << 32) |
               ((long) (data[offset + 4] & 255) << 24) |
               ((data[offset + 5] & 255) << 16) |
               ((data[offset + 6] & 255) << 8) |
               (data[offset + 7] & 255);
    }
}