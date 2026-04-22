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
        Symbol symbol = lookupConstant(hashCode, CONSTANT_NAMEANDTYPE_TAG, name, descriptor);
        if (symbol != null) {
            return symbol.index;
        }
        
        // Create new symbol and add to pool
        symbol = new Symbol(
            constantPoolCount,
            CONSTANT_NAMEANDTYPE_TAG,
            name,
            descriptor,
            hashCode
        );
        
        constantPool[constantPoolCount] = symbol;
        return constantPoolCount++;
    }
    
    private Symbol lookupConstant(
        final int hashCode,
        final int tag,
        final String name,
        final String descriptor) {
        for (int i = 1; i < constantPoolCount; i++) {
            Symbol symbol = constantPool[i];
            if (symbol != null && 
                symbol.tag == tag &&
                symbol.hashCode == hashCode &&
                symbol.name.equals(name) &&
                symbol.value.equals(descriptor)) {
                return symbol;
            }
        }
        return null;
    }
}