import java.util.Arrays;

public class ArrayCopier {

    /** 
     * Este método crea una copia del array proporcionado y asegura que todas las cadenas en el nuevo array contengan solo letras minúsculas. <p> Utilizar este método para copiar arrays de cadenas significa que los cambios en el array src no modifican el array dst.
     */
    private static String[] copiarCadenas(final String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? src[i].toLowerCase() : null;
        }
        return dst;
    }

    public static void main(String[] args) {
        String[] original = {"Hello", "World", "JAVA", null, "Programming"};
        String[] copied = copiarCadenas(original);
        
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copied: " + Arrays.toString(copied));
    }
}