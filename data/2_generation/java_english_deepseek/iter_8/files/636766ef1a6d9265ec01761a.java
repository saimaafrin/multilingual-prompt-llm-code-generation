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
     * Adds a type in the type table of this symbol table. Does nothing if the type table already contains a similar type.
     * @param value an internal class name.
     * @return the index of a new or already existing type Symbol with the given value.
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