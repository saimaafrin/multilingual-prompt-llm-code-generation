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
        
        if (symbol != null) {
            return symbol.index;
        }
        
        symbol = addConstantUtf8(name);
        int nameIndex = symbol.index;
        symbol = addConstantUtf8(descriptor); 
        int descriptorIndex = symbol.index;
        
        symbol = addConstant(new Symbol(size++, Symbol.CONSTANT_NAME_AND_TYPE_TAG, 
                                      nameIndex, descriptorIndex, hashCode));
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
    
    private Symbol addConstant(Symbol symbol) {
        if (size >= symbols.length) {
            Symbol[] newSymbols = new Symbol[symbols.length * 2];
            System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
            symbols = newSymbols;
        }
        symbols[size - 1] = symbol;
        return symbol;
    }
    
    private Symbol addConstantUtf8(String value) {
        int hashCode = Symbol.CONSTANT_UTF8_TAG + value.hashCode();
        Symbol symbol = lookupSymbol(hashCode);
        if (symbol != null) {
            return symbol;
        }
        return addConstant(new Symbol(size++, Symbol.CONSTANT_UTF8_TAG, value, hashCode));
    }
}