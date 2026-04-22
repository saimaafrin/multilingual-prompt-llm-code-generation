import java.util.Arrays;

public class ByteArrayCopier {

    /**
     * Copia i byte in un {@code byte[]}.
     *
     * @return una copia dell'array di byte
     */
    public byte[] toByteArray(byte[] original) {
        if (original == null) {
            return null;
        }
        return Arrays.copyOf(original, original.length);
    }
}