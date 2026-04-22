import java.util.Arrays;

public class ArrayComparator {

    /**
     * Devuelve verdadero si el contenido del array interno y el array proporcionado coinciden.
     * 
     * @param data El array de bytes a comparar.
     * @param offset El índice inicial en el array proporcionado desde donde comenzar la comparación.
     * @param len La longitud de la subsección del array proporcionado a comparar.
     * @return true si los contenidos coinciden, false en caso contrario.
     */
    public boolean equals(final byte[] internalArray, final byte[] data, int offset, final int len) {
        if (internalArray == null || data == null || offset < 0 || len < 0 || offset + len > data.length || len != internalArray.length) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (internalArray[i] != data[offset + i]) {
                return false;
            }
        }

        return true;
    }
}