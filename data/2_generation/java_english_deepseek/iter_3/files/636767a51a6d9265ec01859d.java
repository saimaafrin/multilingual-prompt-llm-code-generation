import java.util.Arrays;

public class ArrayComparator {

    private byte[] internalArray;

    public ArrayComparator(byte[] internalArray) {
        this.internalArray = internalArray;
    }

    /**
     * Returns true if the contents of the internal array and the provided array match.
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
        ArrayComparator comparator = new ArrayComparator(internalArray);

        byte[] data = {0, 1, 2, 3, 4, 5, 6};
        int offset = 1;
        int len = 5;

        System.out.println(comparator.equals(data, offset, len)); // Output: true
    }
}