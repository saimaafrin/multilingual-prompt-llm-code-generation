import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
    private final Symbol[] symbols;
    private int size;

    public SymbolTable(int initialCapacity) {
        this.symbols = new Symbol[initialCapacity];
        this.size = 1;
    }

    int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Check if symbol already exists
        Symbol symbol = lookupSymbol(hashCode);
        while (symbol != null) {
            if (symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name)
                && symbol.value.equals(descriptor)) {
                return symbol.index;
            }
            symbol = lookupSymbol(hashCode + 1);
        }
        
        // Create new symbol
        symbol = new Symbol(
            size++,
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            name,
            descriptor,
            hashCode
        );
        
        // Add to symbol table
        int index = hashCode % symbols.length;
        symbol.next = symbols[index];
        symbols[index] = symbol;
        
        return symbol.index;
    }
    
    private Symbol lookupSymbol(int hashCode) {
        int index = hashCode % symbols.length;
        return symbols[index];
    }
}