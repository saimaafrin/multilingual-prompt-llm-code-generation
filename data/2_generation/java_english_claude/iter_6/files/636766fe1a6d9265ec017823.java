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
        for (int i = 1; i < constantPoolCount; i++) {
            Symbol symbol = symbols[i];
            if (symbol != null && symbol.type == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.hashCode == hashCode) {
                return symbol;
            }
        }
        return null;
    }

    private Symbol addConstantNameAndTypeSymbol(String name, String descriptor, int hashCode) {
        Symbol symbol = new Symbol(
            constantPoolCount++,
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            addConstantUtf8(name),
            addConstantUtf8(descriptor),
            hashCode
        );
        symbols[symbol.index] = symbol;
        return symbol;
    }

    private int addConstantUtf8(String value) {
        // Implementation for adding UTF8 constant omitted for brevity
        // Would follow similar pattern of checking existing entries then adding if not found
        return 0;
    }
}