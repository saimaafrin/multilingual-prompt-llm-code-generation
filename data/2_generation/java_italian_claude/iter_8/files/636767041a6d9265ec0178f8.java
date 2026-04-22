public class ArrayUtils {
    /**
     * Questo metodo crea una copia dell'array fornito e garantisce che tutte le stringhe 
     * nel nuovo array creato contengano solo lettere minuscole.
     * Utilizzare questo metodo per copiare array di stringhe significa che le modifiche 
     * all'array src non modificano l'array dst.
     *
     * @param src array sorgente da copiare
     * @return nuovo array con stringhe in minuscolo
     */
    private static String[] copyStrings(final String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            if (src[i] != null) {
                dst[i] = src[i].toLowerCase();
            }
        }
        return dst;
    }
}