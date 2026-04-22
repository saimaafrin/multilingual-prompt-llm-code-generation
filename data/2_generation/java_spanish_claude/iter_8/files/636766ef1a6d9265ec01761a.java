import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<String> types;

    public SymbolTable() {
        types = new ArrayList<>();
    }

    /**
     * Agrega un tipo en la tabla de tipos de esta tabla de símbolos. No hace nada si la tabla de tipos ya contiene un tipo similar.
     * @param value un nombre de clase interno.
     * @return el índice de un nuevo tipo o de un tipo ya existente con el valor dado.
     */
    public int addType(final String value) {
        // Check if type already exists
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(value)) {
                return i;
            }
        }
        
        // Add new type if it doesn't exist
        types.add(value);
        return types.size() - 1;
    }
}