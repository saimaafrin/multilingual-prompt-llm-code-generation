import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private List<TypeSymbol> typeTable;
    
    public SymbolTable() {
        typeTable = new ArrayList<>();
    }
    
    public int addType(String value) {
        // Check if type already exists
        for (int i = 0; i < typeTable.size(); i++) {
            if (typeTable.get(i).getValue().equals(value)) {
                return i;
            }
        }
        
        // Add new type if not found
        TypeSymbol newType = new TypeSymbol(value);
        typeTable.add(newType);
        return typeTable.size() - 1;
    }
    
    // Inner class to represent a type symbol
    private static class TypeSymbol {
        private String value;
        
        public TypeSymbol(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
}