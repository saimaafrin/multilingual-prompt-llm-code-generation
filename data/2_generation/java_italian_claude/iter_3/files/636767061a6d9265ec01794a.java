import java.io.File;

public class FilenameUtils {

    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /**
     * Restituisce l'indice dell'ultimo carattere separatore dell'estensione, che è un punto.
     * <p>
     * Questo metodo verifica anche che non ci sia un separatore di directory dopo l'ultimo punto.
     * Per fare ciò, utilizza {@link #indexOfLastSeparator(String)} che gestirà un file sia in formato Unix che Windows.
     * <p>
     * L'output sarà lo stesso indipendentemente dalla macchina su cui il codice viene eseguito.
     *
     * @param filename il nome del file in cui trovare l'ultimo separatore di percorso, null restituisce -1
     * @return l'indice dell'ultimo carattere separatore, o -1 se non esiste tale carattere
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        int lastSeparator = indexOfLastSeparator(filename);

        // Se non c'è un punto o se l'ultimo separatore è dopo l'ultimo punto
        if (extensionPos == -1 || lastSeparator > extensionPos) {
            return -1;
        }
        return extensionPos;
    }

    /**
     * Metodo di supporto per trovare l'ultimo separatore di directory
     */
    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}