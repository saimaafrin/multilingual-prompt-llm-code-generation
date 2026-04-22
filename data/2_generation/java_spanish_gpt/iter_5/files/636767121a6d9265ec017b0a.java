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
        
        // Retorna el índice donde termina la línea
        return index + 1; // +1 para incluir el \r
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String headers = "Header1: value1\r\nHeader2: value2\r\n";
        int endIndex = headers.length() - 1; // Último índice
        int lineEndIndex = parser.parseEndOfLine(headers, endIndex);
        System.out.println("End of line index: " + lineEndIndex);
    }
}