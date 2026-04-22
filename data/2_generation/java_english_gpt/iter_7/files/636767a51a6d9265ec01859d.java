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
        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        byte[] internal = {1, 2, 3, 4, 5};
        ArrayComparer comparer = new ArrayComparer(internal);
        byte[] external = {0, 1, 2, 3, 4, 5};
        System.out.println(comparer.equals(external, 1, 5)); // Should print true
        System.out.println(comparer.equals(external, 0, 5)); // Should print false
    }
}