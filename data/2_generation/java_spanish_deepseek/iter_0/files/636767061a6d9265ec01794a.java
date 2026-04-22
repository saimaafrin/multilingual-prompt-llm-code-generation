import java.util.Objects;

public class FileUtils {

    /**
     * Devuelve el índice del último carácter separador de extensión, que es un punto. <p> Este método también verifica que no haya un separador de directorio después del último punto. Para hacer esto, utiliza {@link #indexOfLastSeparator(String)},que manejará un archivo en formato Unix o Windows. <p> La salida será la misma independientemente de la máquina en la que se ejecute el código.
     * @param filename  el nombre del archivo en el que encontrar el último separador de ruta, null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int lastDotIndex = filename.lastIndexOf('.');

        // Si no hay punto o el punto está antes del último separador de ruta, no hay extensión
        if (lastDotIndex == -1 || (lastSeparatorIndex != -1 && lastDotIndex < lastSeparatorIndex)) {
            return -1;
        }

        return lastDotIndex;
    }

    /**
     * Devuelve el índice del último separador de ruta en el nombre del archivo.
     * @param filename  el nombre del archivo, null devuelve -1
     * @return el índice del último separador de ruta, o -1 si no existe tal carácter
     */
    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastUnixSeparator = filename.lastIndexOf('/');
        int lastWindowsSeparator = filename.lastIndexOf('\\');

        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        System.out.println(indexOfExtension("example.txt")); // 7
        System.out.println(indexOfExtension("path/to/file.txt")); // 14
        System.out.println(indexOfExtension("path/to/file")); // -1
        System.out.println(indexOfExtension(null)); // -1
    }
}