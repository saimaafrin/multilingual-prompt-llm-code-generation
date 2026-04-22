public class FilePathSeparator {

    /** 
     * Devuelve el índice del último carácter separador de directorio. <p> Este método manejará un archivo en formato Unix o Windows. Se devuelve la posición de la última barra inclinada o barra invertida. <p> La salida será la misma independientemente de la máquina en la que se ejecute el código.
     * @param filename  el nombre del archivo en el que se busca el último separador de ruta, null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixSeparator = filename.lastIndexOf('/');
        int lastWindowsSeparator = filename.lastIndexOf('\\');
        
        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(indexOfLastSeparator("C:\\Users\\User\\Documents\\file.txt")); // 17
        System.out.println(indexOfLastSeparator("/home/user/documents/file.txt")); // 14
        System.out.println(indexOfLastSeparator("file.txt")); // -1
        System.out.println(indexOfLastSeparator(null)); // -1
    }
}