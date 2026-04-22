public class HeaderParser {

    /** 
     * Omite bytes hasta el final de la línea actual.
     * @param headerPart Las cabeceras que se están analizando.
     * @param end Índice del último byte que aún no ha sido procesado.
     * @return Índice de la secuencia \r\n, que indica el final de la línea.
     */
    private int parseEndOfLine(String headerPart, int end) {
        // Busca la secuencia de fin de línea \r\n
        int index = headerPart.indexOf("\r\n", 0);
        
        // Si no se encuentra, se retorna el índice original
        if (index == -1 || index > end) {
            return end;
        }
        
        // Retorna el índice donde se encuentra la secuencia de fin de línea
        return index;
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String header = "Header1: value1\r\nHeader2: value2\r\n";
        int endIndex = header.length();
        int lineEndIndex = parser.parseEndOfLine(header, endIndex);
        System.out.println("End of line index: " + lineEndIndex);
    }
}