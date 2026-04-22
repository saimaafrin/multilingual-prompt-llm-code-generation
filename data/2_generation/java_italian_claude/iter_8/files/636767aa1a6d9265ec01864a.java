import java.util.Arrays;

public class ByteArrayConverter {
    private byte[] data;
    
    public ByteArrayConverter(byte[] input) {
        this.data = input;
    }
    
    /**
     * Copia i byte in un {@code byte[]}.
     */
    public byte[] toByteArray() {
        if (data == null) {
            return new byte[0];
        }
        return Arrays.copyOf(data, data.length);
    }
}