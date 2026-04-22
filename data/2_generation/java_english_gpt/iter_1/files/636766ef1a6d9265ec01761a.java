import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> typeTable;
    private int currentIndex;

    public SymbolTable() {
        this.typeTable = new HashMap<>();
        this.currentIndex = 0;
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
            typeTable.put(value, currentIndex);
            return currentIndex++;
        }
    }

    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        System.out.println(symbolTable.addType("MyClass")); // Output: 0
        System.out.println(symbolTable.addType("MyClass")); // Output: 0
        System.out.println(symbolTable.addType("AnotherClass")); // Output: 1
    }
}