import java.nio.ByteBuffer;

public class ByteSearcher {

    protected int findByte(byte value, int pos, ByteBuffer buffer) {
        if (buffer == null || pos < 0 || pos >= buffer.limit()) {
            throw new IllegalArgumentException("Invalid buffer or position");
        }

        for (int i = pos; i < buffer.limit(); i++) {
            if (buffer.get(i) == value) {
                return i;
            }
        }

        return -1;
    }
}