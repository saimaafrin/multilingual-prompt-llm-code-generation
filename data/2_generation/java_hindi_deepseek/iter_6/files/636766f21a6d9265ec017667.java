import java.nio.ByteBuffer;

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
            throw new IndexOutOfBoundsException("Offset is out of bounds");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 2);
        return buffer.getShort();
    }
}