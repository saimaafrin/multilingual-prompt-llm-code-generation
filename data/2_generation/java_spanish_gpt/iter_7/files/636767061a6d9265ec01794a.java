public class FileExtensionSeparator {

    /**
     * Devuelve el índice del último carácter separador de extensión, que es un punto. <p> Este método también verifica que no haya un separador de directorio después del último punto. Para hacer esto, utiliza {@link #indexOfLastSeparator(String)},que manejará un archivo en formato Unix o Windows. <p> La salida será la misma independientemente de la máquina en la que se ejecute el código.
     * @param filename  el nombre del archivo en el que encontrar el último separador de ruta, null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastDotIndex = filename.lastIndexOf('.');
        int lastSeparatorIndex = indexOfLastSeparator(filename);

        // Verifica que no haya un separador de directorio después del último punto
        if (lastDotIndex > lastSeparatorIndex) {
            return lastDotIndex;
        }

        return -1;
    }

    /**
     * Encuentra el índice del último separador de directorio en el nombre del archivo.
     * @param filename el nombre del archivo
     * @return el índice del último separador de directorio, o -1 si no existe
     */
    private static int indexOfLastSeparator(String filename) {
        int lastUnixSeparator = filename.lastIndexOf('/');
        int lastWindowsSeparator = filename.lastIndexOf('\\');
        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String filename = "C:\\Users\\example\\file.txt";
        int index = indexOfExtension(filename);
        System.out.println("El índice del último separador de extensión es: " + index);
    }
}