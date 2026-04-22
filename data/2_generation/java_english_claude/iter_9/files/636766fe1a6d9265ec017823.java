import org.objectweb.asm.Symbol;

public class SymbolTable {
    private static final int CONSTANT_NAME_AND_TYPE_TAG = 12;
    private final Symbol[] symbols;
    private int size;

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Look for an existing entry
        Symbol symbol = symbols[hashCode % symbols.length];
        while (symbol != null) {
            if (symbol.tag == CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name)
                && symbol.value.equals(descriptor)) {
                return symbol.index;
            }
            symbol = symbol.next;
        }
        
        // Not found, create new entry
        symbol = new Symbol(
            size++,
            CONSTANT_NAME_AND_TYPE_TAG,
            name,
            descriptor,
            null,
            symbols[hashCode % symbols.length]
        );
        symbols[hashCode % symbols.length] = symbol;
        return symbol.index;
    }
}