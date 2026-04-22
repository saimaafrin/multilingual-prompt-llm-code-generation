import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class ByteVector {
    private ByteArrayOutputStream buffer;

    public ByteVector() {
        buffer = new ByteArrayOutputStream();
    }

    /** 
     * Puts an int into this byte vector. The byte vector is automatically enlarged if necessary.
     * @param intValue an int.
     * @return this byte vector.
     */
    public ByteVector putInt(final int intValue) {
        byte[] intBytes = ByteBuffer.allocate(4).putInt(intValue).array();
        buffer.write(intBytes, 0, intBytes.length);
        return this;
    }
}