import java.util.Objects;

public class HeaderParser {

    /**
     * Salta i byte fino alla fine della riga corrente.
     * @param headerPart Le intestazioni che vengono analizzate.
     * @param end Indice dell'ultimo byte che deve ancora essere elaborato.
     * @return Indice della sequenza \r\n, che indica la fine della riga.
     */
    private int parseEndOfLine(String headerPart, int end) {
        Objects.requireNonNull(headerPart);
        
        int index = end;
        while (index < headerPart.length()) {
            // Cerca la sequenza \r\n che indica fine riga
            if (index + 1 < headerPart.length() && 
                headerPart.charAt(index) == '\r' && 
                headerPart.charAt(index + 1) == '\n') {
                return index;
            }
            index++;
        }
        
        // Se non trova \r\n ritorna l'ultimo indice valido
        return headerPart.length() - 1;
    }
}