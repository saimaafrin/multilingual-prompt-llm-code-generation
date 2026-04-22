import java.util.Arrays;

public class StringArrayCopier {

    /**
     * Questo metodo crea una copia dell'array fornito e garantisce che tutte le stringhe nel nuovo array creato contengano solo lettere minuscole. <p> Utilizzare questo metodo per copiare array di stringhe significa che le modifiche all'array src non modificano l'array dst.
     */
    private static String[] copyStrings(final String[] src) {
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
        String[] copied = copyStrings(original);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copied: " + Arrays.toString(copied));
    }
}