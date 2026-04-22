public class FilenameUtils {
    
    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    /**
     * Devuelve el índice del último carácter separador de extensión, que es un punto.
     * <p>
     * Este método también verifica que no haya un separador de directorio después del último punto.
     * Para hacer esto, utiliza {@link #indexOfLastSeparator(String)}, que manejará un archivo en formato Unix o Windows.
     * <p>
     * La salida será la misma independientemente de la máquina en la que se ejecute el código.
     *
     * @param filename el nombre del archivo en el que encontrar el último separador de ruta, null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        int lastSeparator = indexOfLastSeparator(filename);
        
        // Si no hay punto o el último separador está después del último punto
        if (extensionPos == -1 || lastSeparator > extensionPos) {
            return -1;
        }
        return extensionPos;
    }
    
    /**
     * Método auxiliar para encontrar el último separador de directorio
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