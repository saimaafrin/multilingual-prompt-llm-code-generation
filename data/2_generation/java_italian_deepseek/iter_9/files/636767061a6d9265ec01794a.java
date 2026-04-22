import java.util.Objects;

public class FileUtils {

    /**
     * Restituisce l'indice dell'ultimo carattere separatore dell'estensione, che è un punto. <p> Questo metodo verifica anche che non ci sia un separatore di directory dopo l'ultimo punto. Per fare ciò, utilizza {@link #indexOfLastSeparator(String)} che gestirà un file sia in formato Unix che Windows. <p> L'output sarà lo stesso indipendentemente dalla macchina su cui il codice viene eseguito.
     * @param filename  il nome del file in cui trovare l'ultimo separatore di percorso, null restituisce -1
     * @return l'indice dell'ultimo carattere separatore, o -1 se non esiste tale carattere
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int extensionIndex = filename.lastIndexOf('.');

        // Se non c'è un punto o se il punto è prima dell'ultimo separatore di directory, restituisci -1
        if (extensionIndex == -1 || (lastSeparatorIndex != -1 && extensionIndex < lastSeparatorIndex)) {
            return -1;
        }

        return extensionIndex;
    }

    /**
     * Restituisce l'indice dell'ultimo separatore di directory nel nome del file.
     * @param filename il nome del file in cui trovare l'ultimo separatore di directory
     * @return l'indice dell'ultimo separatore di directory, o -1 se non esiste tale carattere
     */
    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');

        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOfExtension("file.txt")); // 4
        System.out.println(indexOfExtension("path/to/file.txt")); // 13
        System.out.println(indexOfExtension("path\\to\\file.txt")); // 13
        System.out.println(indexOfExtension("file")); // -1
        System.out.println(indexOfExtension("path/to/file")); // -1
        System.out.println(indexOfExtension(null)); // -1
    }
}