import java.io.File;

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
        
        int lastDotIndex = path.lastIndexOf('.');
        if (lastDotIndex == -1) {
            // No extension found
            return path;
        }
        
        int lastSeparatorIndex = path.lastIndexOf(File.separator);
        if (lastSeparatorIndex > lastDotIndex) {
            // Last dot is in the path portion, not the filename
            return path;
        }
        
        return path.substring(0, lastDotIndex);
    }
}