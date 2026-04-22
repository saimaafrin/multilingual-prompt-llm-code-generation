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
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(value)) {
                return i; // Return existing index
            }
        }
        
        // Add new type and return its index
        types.add(value);
        return types.size() - 1;
    }
}