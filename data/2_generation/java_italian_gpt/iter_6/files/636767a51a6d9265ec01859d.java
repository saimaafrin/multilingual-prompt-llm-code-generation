import java.util.Arrays;

public class ArrayComparer {
    
    /** 
     * Restituisce true se i contenuti dell'array interno e dell'array fornito corrispondono.
     */
    private byte[] internalArray;

    public ArrayComparer(byte[] internalArray) {
        this.internalArray = internalArray;
    }

    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length || len > internalArray.length) {
            return false;
        }
        return Arrays.equals(internalArray, 0, len, data, offset, offset + len);
    }

    public static void main(String[] args) {
        byte[] internal = {1, 2, 3, 4, 5};
        ArrayComparer comparer = new ArrayComparer(internal);
        
        byte[] external = {0, 1, 2, 3, 4, 5};
        boolean result = comparer.equals(external, 1, 5);
        System.out.println(result); // Output: true
    }
}