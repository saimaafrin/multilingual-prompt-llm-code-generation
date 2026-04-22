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
        Symbol symbol = lookupSymbol(hashCode);
        
        if (symbol != null && symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name) && symbol.value.equals(descriptor)) {
            return symbol.index;
        }
        
        symbol = new Symbol(size++, Symbol.CONSTANT_NAME_AND_TYPE_TAG, name, descriptor);
        addSymbol(symbol);
        return symbol.index;
    }
    
    private Symbol lookupSymbol(int hashCode) {
        for (int i = 0; i < size; i++) {
            if (symbols[i] != null && symbols[i].hashCode == hashCode) {
                return symbols[i]; 
            }
        }
        return null;
    }
    
    private void addSymbol(Symbol symbol) {
        if (size >= symbols.length) {
            Symbol[] newSymbols = new Symbol[symbols.length * 2];
            System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
            symbols = newSymbols;
        }
        symbols[size - 1] = symbol;
    }
}