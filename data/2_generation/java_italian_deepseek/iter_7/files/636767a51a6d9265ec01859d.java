import java.util.Arrays;

public class ArrayComparator {

    /**
     * Restituisce true se i contenuti dell'array interno e dell'array fornito corrispondono.
     *
     * @param data   L'array di byte da confrontare.
     * @param offset L'indice iniziale nell'array interno da cui iniziare il confronto.
     * @param len    La lunghezza del segmento da confrontare.
     * @return true se i contenuti corrispondono, false altrimenti.
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