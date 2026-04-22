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
        
        int lastDotIndex = path.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return path;
        }
        
        int lastSeparatorIndex = path.lastIndexOf('/');
        if (lastSeparatorIndex > lastDotIndex) {
            return path;
        }
        
        return path.substring(0, lastDotIndex);
    }
}