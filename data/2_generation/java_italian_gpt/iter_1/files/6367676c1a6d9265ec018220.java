public class FilePathUtil {

    /** 
     * Rimuove l'estensione del nome file dal percorso fornito, ad esempio "mypath/myfile.txt" -&gt; "mypath/myfile".
     * @param path il percorso del file (può essere <code>null</code>)
     * @return il percorso con l'estensione del nome file rimossa, oppure <code>null</code> se non presente
     */
    public static String stripFilenameExtension(String path) {
        if (path == null) {
            return null;
        }
        
        int lastDotIndex = path.lastIndexOf('.');
        int lastSlashIndex = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        
        if (lastDotIndex > lastSlashIndex) {
            return path.substring(0, lastDotIndex);
        }
        
        return path; // No extension found
    }

    public static void main(String[] args) {
        String path1 = "mypath/myfile.txt";
        String path2 = "mypath/myfile";
        String path3 = null;

        System.out.println(stripFilenameExtension(path1)); // Output: mypath/myfile
        System.out.println(stripFilenameExtension(path2)); // Output: mypath/myfile
        System.out.println(stripFilenameExtension(path3)); // Output: null
    }
}