import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<Symbol> typeTable;
    
    public SymbolTable() {
        this.typeTable = new ArrayList<>();
    }
    
    private static class Symbol {
        final String value;
        
        Symbol(String value) {
            this.value = value;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Symbol) {
                return ((Symbol) obj).value.equals(this.value);
            }
            return false;
        }
    }
    
    public int addType(final String value) {
        Symbol symbol = new Symbol(value);
        int index = typeTable.indexOf(symbol);
        if (index == -1) {
            typeTable.add(symbol);
            return typeTable.size() - 1;
        }
        return index;
    }
}