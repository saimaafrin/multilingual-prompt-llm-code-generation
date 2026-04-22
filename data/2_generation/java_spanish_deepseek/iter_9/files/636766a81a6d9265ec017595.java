import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    private List<Byte> byteList;

    public ByteVector() {
        this.byteList = new ArrayList<>();
    }

    /**
     * Coloca dos bytes en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param byteValue1 un byte.
     * @param byteValue2 otro byte.
     * @return este vector de bytes.
     */
    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        byteList.add((byte) byteValue1);
        byteList.add((byte) byteValue2);
        return this;
    }

    // Optional: Method to get the byte array representation of the ByteVector
    public byte[] toByteArray() {
        byte[] array = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            array[i] = byteList.get(i);
        }
        return array;
    }
}