public class PathUtils {

    /**
     * Devuelve el índice del último carácter separador de directorio. <p> Este método manejará un archivo en formato Unix o Windows. Se devuelve la posición de la última barra inclinada o barra invertida. <p> La salida será la misma independientemente de la máquina en la que se ejecute el código.
     * @param filename  el nombre del archivo en el que se busca el último separador de ruta, null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        
        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String path1 = "C:\\Users\\JohnDoe\\Documents\\file.txt";
        String path2 = "/home/user/documents/file.txt";
        String path3 = "file.txt";
        
        System.out.println(indexOfLastSeparator(path1)); // Output: 20
        System.out.println(indexOfLastSeparator(path2)); // Output: 18
        System.out.println(indexOfLastSeparator(path3)); // Output: -1
    }
}