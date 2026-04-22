import java.util.Arrays;

public class StringCopier {

    /**
     * Este método crea una copia del array proporcionado y asegura que todas las cadenas en el nuevo array contengan solo letras minúsculas. <p> Utilizar este método para copiar arrays de cadenas significa que los cambios en el array src no modifican el array dst.
     * 
     * @param src El array de cadenas original.
     * @return Un nuevo array de cadenas con todas las cadenas en minúsculas.
     */
    private static String[] copiarCadenas(final String[] src) {
        if (src == null) {
            return null;
        }

        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            if (src[i] != null) {
                dst[i] = src[i].toLowerCase();
            } else {
                dst[i] = null;
            }
        }
        return dst;
    }

    public static void main(String[] args) {
        String[] original = {"Hello", "WORLD", "Java", null, "Programming"};
        String[] copia = copiarCadenas(original);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copia: " + Arrays.toString(copia));
    }
}