import java.util.Arrays;

public class ArrayComparer {
    
    /** 
     * Devuelve verdadero si el contenido del array interno y el array proporcionado coinciden.
     */
    private byte[] internalData;

    public ArrayComparer(byte[] internalData) {
        this.internalData = internalData;
    }

    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length || len > internalData.length) {
            return false;
        }
        return Arrays.equals(Arrays.copyOfRange(internalData, 0, len), Arrays.copyOfRange(data, offset, offset + len));
    }

    public static void main(String[] args) {
        byte[] internal = {1, 2, 3, 4, 5};
        ArrayComparer comparer = new ArrayComparer(internal);
        
        byte[] external = {0, 1, 2, 3, 4, 5};
        boolean result = comparer.equals(external, 1, 4); // Should return true
        System.out.println(result); // Output: true
    }
}