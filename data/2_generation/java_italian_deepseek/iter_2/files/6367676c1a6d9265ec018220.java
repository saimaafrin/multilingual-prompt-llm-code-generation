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
        
        int lastDotIndex = path.lastIndexOf('.');
        int lastSeparatorIndex = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        
        if (lastDotIndex > lastSeparatorIndex) {
            return path.substring(0, lastDotIndex);
        }
        
        return path;
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension("myfile.txt"));       // Output: myfile
        System.out.println(stripFilenameExtension(null));              // Output: null
    }
}