public class ArrayUtils {
    /**
     * Este método crea una copia del array proporcionado y asegura que todas las cadenas 
     * en el nuevo array contengan solo letras minúsculas.
     * Utilizar este método para copiar arrays de cadenas significa que los cambios en el 
     * array src no modifican el array dst.
     * @param src Array origen que se va a copiar
     * @return Nuevo array con las cadenas en minúsculas
     */
    private static String[] copiarCadenas(final String[] src) {
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