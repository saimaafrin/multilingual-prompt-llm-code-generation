import org.objectweb.asm.Symbol;
import org.objectweb.asm.Constants;

public class SymbolTable {
    private final Symbol[] symbols;
    private int size;
    
    public SymbolTable(int initialCapacity) {
        this.symbols = new Symbol[initialCapacity];
        this.size = 1;
    }

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        Symbol symbol = getSymbol(hashCode);
        
        while (symbol != null) {
            if (symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name)
                && symbol.value.equals(descriptor)) {
                return symbol.index;
            }
            symbol = symbol.next;
        }

        symbol = new Symbol(
            size++,
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            name,
            descriptor,
            hashCode,
            getSymbol(hashCode));
        
        symbols[symbol.index] = symbol;
        return symbol.index;
    }
    
    private Symbol getSymbol(int hashCode) {
        return symbols[hashCode % symbols.length];
    }
}