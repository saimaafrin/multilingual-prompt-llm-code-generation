import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private final List<Symbol> typeTable;

    public SymbolTable() {
        this.typeTable = new ArrayList<>();
    }

    public int addType(final String value) {
        // Check if type already exists
        for (int i = 0; i < typeTable.size(); i++) {
            Symbol symbol = typeTable.get(i);
            if (symbol.getValue().equals(value)) {
                return i;
            }
        }
        
        // Add new type if not found
        typeTable.add(new Symbol(value));
        return typeTable.size() - 1;
    }

    private static class Symbol {
        private final String value;

        public Symbol(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}