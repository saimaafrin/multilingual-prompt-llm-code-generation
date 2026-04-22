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
        
        // Look for an existing entry
        Symbol symbol = lookupSymbol(hashCode);
        while (symbol != null) {
            if (symbol.tag == Symbol.CONSTANT_NAME_AND_TYPE_TAG 
                && symbol.name.equals(name)
                && symbol.value.equals(descriptor)) {
                return symbol.index;
            }
            symbol = lookupSymbol(hashCode);
        }
        
        // Not found, create new entry
        int nameIndex = addConstantUtf8(name);
        int descriptorIndex = addConstantUtf8(descriptor);
        
        symbol = new Symbol(
            size++,
            Symbol.CONSTANT_NAME_AND_TYPE_TAG,
            nameIndex,
            descriptorIndex,
            name,
            descriptor,
            hashCode);
            
        addSymbol(symbol);
        return symbol.index;
    }
    
    private Symbol lookupSymbol(int hashCode) {
        // Implementation details omitted for brevity
        return null;
    }
    
    private void addSymbol(Symbol symbol) {
        // Implementation details omitted for brevity
    }
    
    private int addConstantUtf8(String value) {
        // Implementation details omitted for brevity
        return 0;
    }
}