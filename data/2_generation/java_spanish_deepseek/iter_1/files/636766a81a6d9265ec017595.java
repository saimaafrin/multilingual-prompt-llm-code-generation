import java.util.ArrayList;

public class ByteVector {
    private ArrayList<Byte> bytes;

    public ByteVector() {
        this.bytes = new ArrayList<>();
    }

    /**
     * Coloca dos bytes en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param byteValue1 un byte.
     * @param byteValue2 otro byte.
     * @return este vector de bytes.
     */
    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        bytes.add((byte) byteValue1);
        bytes.add((byte) byteValue2);
        return this;
    }

    // Optional: Method to get the byte array representation of the vector
    public byte[] toByteArray() {
        byte[] result = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            result[i] = bytes.get(i);
        }
        return result;
    }
}