import java.util.Objects;

public class FileUtils {

    /**
     * Rimuove l'estensione del nome file dal percorso fornito, ad esempio "mypath/myfile.txt" -> "mypath/myfile".
     * @param path il percorso del file (può essere <code>null</code>)
     * @return il percorso con l'estensione del nome file rimossa, oppure <code>null</code> se non presente
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }

        int lastSeparatorIndex = path.lastIndexOf('/');
        int lastDotIndex = path.lastIndexOf('.');

        // Se non c'è un punto o se il punto è prima dell'ultimo separatore, restituisci il percorso originale
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("myfile.txt"));         // Output: myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));      // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null));                // Output: null
    }
}