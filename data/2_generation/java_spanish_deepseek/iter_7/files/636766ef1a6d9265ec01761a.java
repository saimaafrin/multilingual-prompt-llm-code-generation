import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> typeTable;
    private int nextIndex;

    public SymbolTable() {
        this.typeTable = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * Agrega un tipo en la tabla de tipos de esta tabla de símbolos. No hace nada si la tabla de tipos ya contiene un tipo similar.
     * @param value un nombre de clase interno.
     * @return el índice de un nuevo tipo o de un tipo ya existente con el valor dado.
     */
    public int addType(final String value) {
        if (typeTable.containsKey(value)) {
            return typeTable.get(value);
        } else {
            typeTable.put(value, nextIndex);
            return nextIndex++;
        }
    }
}