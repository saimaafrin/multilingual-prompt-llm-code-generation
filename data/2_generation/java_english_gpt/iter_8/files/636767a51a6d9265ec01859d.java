import java.util.Arrays;

public class ArrayComparer {
    private byte[] internalArray;

    public ArrayComparer(byte[] internalArray) {
        this.internalArray = internalArray;
    }

    /** 
     * Returns true if the contents of the internal array and the provided array match.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        if (len > internalArray.length) {
            return false;
        }
        return Arrays.equals(internalArray, 0, len, data, offset, offset + len);
    }
}