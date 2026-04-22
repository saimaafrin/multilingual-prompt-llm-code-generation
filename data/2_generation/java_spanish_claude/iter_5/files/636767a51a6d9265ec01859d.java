import java.util.Arrays;

public class ByteArrayMatcher {

    private byte[] pattern; // Internal array to compare against

    /**
     * Devuelve verdadero si el contenido del array interno y el array proporcionado coinciden.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || pattern == null) {
            return false;
        }

        if (offset < 0 || len < 0) {
            return false;
        }

        if (offset + len > data.length || len != pattern.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (pattern[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }

    // Constructor to set the internal pattern
    public ByteArrayMatcher(byte[] pattern) {
        this.pattern = pattern;
    }
}