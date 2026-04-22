import java.util.Arrays;

public class HeaderParser {

    /**
     * Omite bytes hasta el final de la línea actual.
     * @param headerPart Las cabeceras que se están analizando.
     * @param end Índice del último byte que aún no ha sido procesado.
     * @return Índice de la secuencia \r\n, que indica el final de la línea.
     */
    private int parseEndOfLine(String headerPart, int end) {
        int index = end;
        
        // Buscar hasta encontrar \r\n o llegar al final
        while (index < headerPart.length() - 1) {
            if (headerPart.charAt(index) == '\r' && 
                headerPart.charAt(index + 1) == '\n') {
                return index;
            }
            index++;
        }
        
        // Si no se encuentra \r\n, devolver el final del string
        return headerPart.length() - 1;
    }
}