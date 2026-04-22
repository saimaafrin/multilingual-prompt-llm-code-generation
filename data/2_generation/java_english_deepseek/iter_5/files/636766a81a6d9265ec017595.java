import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    private List<Byte> bytes;

    public ByteVector() {
        this.bytes = new ArrayList<>();
    }

    /**
     * Puts two bytes into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param byteValue1 a byte.
     * @param byteValue2 another byte.
     * @return this byte vector.
     */
    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        bytes.add((byte) byteValue1);
        bytes.add((byte) byteValue2);
        return this;
    }

    // Optional: Method to get the byte vector as a byte array
    public byte[] toByteArray() {
        byte[] result = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            result[i] = bytes.get(i);
        }
        return result;
    }
}