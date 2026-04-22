import org.objectweb.asm.Symbol;

public class SymbolTable {
    private static final int CONSTANT_NAME_AND_TYPE_TAG = 12;
    private final Symbol[] symbols;
    private int constantPoolCount;

    public SymbolTable(int initialCapacity) {
        this.symbols = new Symbol[initialCapacity];
        this.constantPoolCount = 1;
    }

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAME_AND_TYPE_TAG + name.hashCode() * descriptor.hashCode();
        Symbol symbol = lookupSymbol(hashCode);
        
        if (symbol != null) {
            return symbol.index;
        }
        
        symbol = addConstantNameAndTypeSymbol(name, descriptor, hashCode);
        return symbol.index;
    }

    private Symbol lookupSymbol(int hashCode) {
        for (Symbol symbol : symbols) {
            if (symbol != null && symbol.hashCode == hashCode) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol addConstantNameAndTypeSymbol(String name, String descriptor, int hashCode) {
        Symbol symbol = new Symbol(
            constantPoolCount++,
            CONSTANT_NAME_AND_TYPE_TAG,
            name,
            descriptor,
            hashCode
        );
        
        ensureCapacity();
        symbols[symbol.index] = symbol;
        return symbol;
    }

    private void ensureCapacity() {
        if (constantPoolCount >= symbols.length) {
            Symbol[] newSymbols = new Symbol[symbols.length * 2];
            System.arraycopy(symbols, 0, newSymbols, 0, symbols.length);
            symbols = newSymbols;
        }
    }
}