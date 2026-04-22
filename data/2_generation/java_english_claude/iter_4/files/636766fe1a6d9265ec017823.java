import org.objectweb.asm.Symbol;

public class SymbolTable {
    private static final int CONSTANT_NAME_AND_TYPE_TAG = 12;
    private final Symbol[] symbols;
    private int size;

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Look for an existing entry
        for (int i = 1; i < size; i++) {
            Symbol symbol = symbols[i];
            if (symbol != null && 
                symbol.tag == CONSTANT_NAME_AND_TYPE_TAG &&
                symbol.name.equals(name) && 
                symbol.value.equals(descriptor)) {
                return i;
            }
        }
        
        // Create new entry if not found
        return addConstantSymbol(new Symbol(
            CONSTANT_NAME_AND_TYPE_TAG,
            size++,
            name,
            descriptor,
            hashCode));
    }

    private int addConstantSymbol(Symbol symbol) {
        if (size >= symbols.length) {
            // Expand array if needed
            Symbol[] newSymbols = new Symbol[symbols.length * 2];
            System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
            symbols = newSymbols;
        }
        symbols[size] = symbol;
        return size;
    }
}