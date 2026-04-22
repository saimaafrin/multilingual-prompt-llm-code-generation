import org.objectweb.asm.Symbol;

public class SymbolTable {
    private final Symbol[] constantPool;
    private int constantPoolCount;
    private static final int CONSTANT_NAMEANDTYPE_TAG = 12;
    
    public SymbolTable(int initialCapacity) {
        this.constantPool = new Symbol[initialCapacity];
        this.constantPoolCount = 1;
    }

    public int addConstantNameAndType(final String name, final String descriptor) {
        int hashCode = Symbol.CONSTANT_NAMEANDTYPE_TAG + name.hashCode() * descriptor.hashCode();
        
        // Check if symbol already exists in constant pool
        Symbol symbol = lookupConstant(hashCode);
        if (symbol != null) {
            return symbol.index;
        }
        
        // Create new symbol and add to constant pool
        symbol = new Symbol(
            constantPoolCount,
            CONSTANT_NAMEANDTYPE_TAG,
            addConstantUtf8(name),
            addConstantUtf8(descriptor),
            hashCode);
            
        constantPool[constantPoolCount] = symbol;
        return constantPoolCount++;
    }
    
    private Symbol lookupConstant(int hashCode) {
        for (int i = 1; i < constantPoolCount; i++) {
            Symbol symbol = constantPool[i];
            if (symbol != null && symbol.hashCode == hashCode) {
                return symbol;
            }
        }
        return null;
    }
    
    private int addConstantUtf8(String value) {
        // Implementation for adding UTF8 constant omitted for brevity
        // Would follow similar pattern of checking existence and adding if not found
        return 0;
    }
}