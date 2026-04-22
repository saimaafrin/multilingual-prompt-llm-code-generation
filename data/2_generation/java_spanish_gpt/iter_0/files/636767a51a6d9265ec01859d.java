import java.util.Arrays;

public class ArrayComparer {
    
    private byte[] internalArray;

    public ArrayComparer(byte[] internalArray) {
        this.internalArray = internalArray;
    }

    /** 
     * Devuelve verdadero si el contenido del array interno y el array proporcionado coinciden.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        if (data == null || offset < 0 || len < 0 || offset + len > data.length) {
            return false;
        }
        if (len != internalArray.length) {
            return false;
        }
        return Arrays.equals(internalArray, Arrays.copyOfRange(data, offset, offset + len));
    }
}