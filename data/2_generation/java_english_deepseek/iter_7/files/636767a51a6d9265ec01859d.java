import java.util.Arrays;

public class ByteArrayComparator {

    private byte[] internalArray;

    public ByteArrayComparator(byte[] internalArray) {
        this.internalArray = internalArray;
    }

    /**
     * Returns true if the contents of the internal array and the provided array match.
     *
     * @param data   The array to compare against the internal array.
     * @param offset The starting position in the provided array.
     * @param len    The number of bytes to compare.
     * @return true if the contents match, false otherwise.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length || len > internalArray.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        byte[] internalArray = {1, 2, 3, 4, 5};
        ByteArrayComparator comparator = new ByteArrayComparator(internalArray);

        byte[] data = {0, 1, 2, 3, 4, 5, 6};
        int offset = 1;
        int len = 5;

        System.out.println(comparator.equals(data, offset, len)); // Should print true
    }
}