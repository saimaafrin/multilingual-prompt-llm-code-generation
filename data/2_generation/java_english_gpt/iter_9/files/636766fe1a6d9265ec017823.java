import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> constantPool;
    private int nextIndex;

    public SymbolTable() {
        this.constantPool = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * Adds a CONSTANT_NameAndType_info to the constant pool of this symbol table. Does nothing if the constant pool already contains a similar item.
     * @param name a field or method name.
     * @param descriptor a field or method descriptor.
     * @return a new or already existing Symbol with the given value.
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!constantPool.containsKey(key)) {
            constantPool.put(key, nextIndex);
            nextIndex++;
        }
        return constantPool.get(key);
    }

    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        int index1 = symbolTable.addConstantNameAndType("myMethod", "(I)V");
        int index2 = symbolTable.addConstantNameAndType("myMethod", "(I)V");
        
        System.out.println("Index of first addition: " + index1);
        System.out.println("Index of second addition (should be the same): " + index2);
    }
}