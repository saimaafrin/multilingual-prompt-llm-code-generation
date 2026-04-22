import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<String> types;
    
    public SymbolTable() {
        types = new ArrayList<>();
    }

    /**
     * Aggiunge un tipo nella tabella dei tipi di questa tabella dei simboli. 
     * Non fa nulla se la tabella dei tipi contiene già un tipo simile.
     * @param value un nome di classe interno.
     * @return l'indice di un nuovo tipo o di un tipo già esistente con il valore fornito.
     */
    public int addType(final String value) {
        // Check if type already exists
        int existingIndex = types.indexOf(value);
        if (existingIndex != -1) {
            return existingIndex;
        }
        
        // Add new type and return its index
        types.add(value);
        return types.size() - 1;
    }
}