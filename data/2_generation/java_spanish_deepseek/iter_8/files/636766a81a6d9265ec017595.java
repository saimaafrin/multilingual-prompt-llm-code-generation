import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    private List<Byte> byteList;

    public ByteVector() {
        this.byteList = new ArrayList<>();
    }

    public ByteVector put11(final int byteValue1, final int byteValue2) {
        // Ensure the values are within byte range
        byte b1 = (byte) byteValue1;
        byte b2 = (byte) byteValue2;

        // Add the bytes to the list
        byteList.add(b1);
        byteList.add(b2);

        return this;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            result[i] = byteList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ByteVector byteVector = new ByteVector();
        byteVector.put11(0x12, 0x34);
        byte[] bytes = byteVector.toByteArray();
        for (byte b : bytes) {
            System.out.printf("%02X ", b);
        }
    }
}