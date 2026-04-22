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
    public boolean equals(final byte[] data, int offset, final int len) {
        // Supponiamo che l'array interno sia 'internalData'
        byte[] internalData = getInternalData(); // Metodo fittizio per ottenere l'array interno

        // Controllo dei limiti
        if (offset < 0 || len < 0 || offset + len > internalData.length || len > data.length) {
            return false;
        }

        // Confronto i segmenti degli array
        for (int i = 0; i < len; i++) {
            if (internalData[offset + i] != data[i]) {
                return false;
            }
        }

        return true;
    }

    // Metodo fittizio per ottenere l'array interno
    private byte[] getInternalData() {
        return new byte[]{1, 2, 3, 4, 5}; // Esempio di array interno
    }

    public static void main(String[] args) {
        ArrayComparator comparator = new ArrayComparator();
        byte[] data = {2, 3, 4};
        boolean result = comparator.equals(data, 1, 3);
        System.out.println(result); // Output: true
    }
}