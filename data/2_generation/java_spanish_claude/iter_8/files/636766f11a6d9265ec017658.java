package org.apache.commons.io;

/**
 * Utility class for file operations.
 */
public class FilenameUtils {

    /** The Unix separator character. */
    private static final char UNIX_SEPARATOR = '/';
    
    /** The Windows separator character. */
    private static final char WINDOWS_SEPARATOR = '\\';

    /** 
     * Devuelve el índice del último carácter separador de directorio. <p> 
     * Este método manejará un archivo en formato Unix o Windows. Se devuelve la posición 
     * de la última barra inclinada o barra invertida. <p> La salida será la misma 
     * independientemente de la máquina en la que se ejecute el código.
     * 
     * @param filename  el nombre del archivo en el que se busca el último separador de ruta, 
     *                 null devuelve -1
     * @return el índice del último carácter separador, o -1 si no existe tal carácter
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}