public class HeaderParser {

    /** 
     * Omite bytes hasta el final de la línea actual.
     * @param headerPart Las cabeceras que se están analizando.
     * @param end Índice del último byte que aún no ha sido procesado.
     * @return Índice de la secuencia \r\n, que indica el final de la línea.
     */
    private int parseEndOfLine(String headerPart, int end) {
        int index = headerPart.indexOf("\r\n", 0);
        if (index == -1 || index > end) {
            return end; // No se encontró el final de la línea o está fuera de los límites
        }
        return index; // Retorna el índice donde se encuentra \r\n
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String headers = "Header1: value1\r\nHeader2: value2\r\n";
        int end = headers.length();
        int lineEndIndex = parser.parseEndOfLine(headers, end);
        System.out.println("End of line index: " + lineEndIndex);
    }
}