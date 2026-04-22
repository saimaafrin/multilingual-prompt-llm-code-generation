import java.io.ByteArrayOutputStream;

public class ByteSearcher {

    private byte[] buffer;

    public ByteSearcher(byte[] buffer) {
        this.buffer = buffer;
    }

    /**
     * Searches for a byte of specified value in the <code>buffer</code>, starting at the specified <code>position</code>.
     * @param value The value to find.
     * @param pos   The starting position for searching.
     * @return The position of byte found, counting from beginning of the<code>buffer</code>, or <code>-1</code> if not found.
     */
    protected int findByte(byte value, int pos) {
        if (buffer == null || pos < 0 || pos >= buffer.length) {
            return -1;
        }

        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i;
            }
        }
        return -1;
    }
}