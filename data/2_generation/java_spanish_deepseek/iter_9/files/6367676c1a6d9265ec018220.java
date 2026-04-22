import java.util.Objects;

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

        int lastSeparatorIndex = path.lastIndexOf('/');
        int lastDotIndex = path.lastIndexOf('.');

        // Si no hay punto o el punto está antes del último separador, no hay extensión
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return path;
        }

        return path.substring(0, lastDotIndex);
    }

    public static void main(String[] args) {
        System.out.println(stripFilenameExtension("mypath/myfile.txt")); // Output: mypath/myfile
        System.out.println(stripFilenameExtension("myfile.txt"));        // Output: myfile
        System.out.println(stripFilenameExtension("mypath/myfile"));    // Output: mypath/myfile
        System.out.println(stripFilenameExtension(null));               // Output: null
    }
}