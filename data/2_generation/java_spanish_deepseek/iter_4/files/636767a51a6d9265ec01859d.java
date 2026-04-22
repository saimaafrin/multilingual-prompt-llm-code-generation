import java.util.Arrays;

public class ArrayComparator {

    /**
     * Devuelve verdadero si el contenido del array interno y el array proporcionado coinciden.
     * 
     * @param data El array de bytes a comparar.
     * @param offset El índice inicial en el array interno para comenzar la comparación.
     * @param len La longitud de la subsección a comparar.
     * @return Verdadero si los contenidos coinciden, falso en caso contrario.
     */
    public boolean equals(final byte[] internalArray, final byte[] data, int offset, final int len) {
        if (internalArray == null || data == null) {
            return false;
        }
        if (offset < 0 || len < 0 || offset + len > internalArray.length || len > data.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (internalArray[offset + i] != data[i]) {
                return false;
            }
        }
        return true;
    }
}