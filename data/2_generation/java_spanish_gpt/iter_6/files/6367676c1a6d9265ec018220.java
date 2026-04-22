public class FileUtils {

    /** 
     * Elimina la extensión del nombre de archivo de la ruta dada, por ejemplo, "mypath/myfile.txt" -> "mypath/myfile".
     * @param path la ruta del archivo (puede ser <code>null</code>)
     * @return la ruta con la extensión del nombre de archivo eliminada, o <code>null</code> si no hay ninguna
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
        // Test cases
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));     // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null));                // Output: null
        System.out.println(stripFilenameExtension("mypath/myfile."));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension("mypath/myfile.tar.gz")); // Output: mypath/myfile.tar
    }
}