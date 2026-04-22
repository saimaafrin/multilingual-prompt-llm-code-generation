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
     * Agrega un tipo en la tabla de tipos de esta tabla de símbolos. No hace nada si la tabla de tipos ya contiene un tipo similar.
     * @param value un nombre de clase interno.
     * @return el índice de un nuevo tipo o de un tipo ya existente con el valor dado.
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